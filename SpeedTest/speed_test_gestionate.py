
from ast import Try
import ssl
import sys
import os
import urllib.request as urllib2
import xml.etree.ElementTree as ET
import xml.dom.minidom
import mysql.connector
if len(sys.argv) < 4:
    raise Exception("Invalid number of arguments. This script requires minimum [ 2 ] arguments")
try:
    usuario = sys.argv[1]
    ap_id = sys.argv[2]
    fecha_solicitud = sys.argv[3]
except Exception as e:
	raise Exception('Invalid parameter. Error: ' + str(e))

def main(properties,usuario,ap_id):
    work_flow_process_id = registrar_ap_id(properties,ap_id)
    registrar_speed_test_call(properties,usuario,ap_id,work_flow_process_id,fecha_solicitud)
def registrar_ap_id(properties,ap_id):
    process_id = None
    try:
        url = properties["URL_ExecuteAndReturnPID"]
        body_str = get_execute_and_return_pid_body(ap_id)
        result_soap = get_search_result_from_soap(url,body_str,'ExecuteAndReturnPIDResult')
        workflow_tracking_id = get_value_from_element(result_soap,'WorkflowTrackingID')
        process_id = get_value_from_element(result_soap,'ProcessID')
        print("Registro  ap_id ={0} process_id {1} workflow_tracking_id {2} ".format(ap_id,process_id,workflow_tracking_id))
        return process_id
    except Exception as e:
        print(e)
    return process_id
def existe_llamada_anterior(properties,usuario,ap_id):
    try:
        respuesta = True
        database = properties['DB_STR_CONNECTION'].split('jdbc:mysql://')[1].split("/")[1].split("?")[0]
        server= properties['DB_STR_CONNECTION'].split('jdbc:mysql://')[1].split(":")[0]
        mydb = mysql.connector.connect(host=server,user=properties['DB_USER'],password=properties['DB_PWD'], database=database)
        strSql = "select count(*) as num_sol from speed_test_call where usuario='{0}' and ap_id = '{1}' and estado = 'registro' and year(fecha) = year(now()) and month(fecha) = month(now()) and day(fecha) = day(now()) ;".format(usuario,ap_id)
        cursor = mydb.cursor()
        cursor.execute(strSql)
        records = cursor.fetchall()
        for x in records:
            if(x[0] == 0):
                respuesta = False
            else:
                respuesta = True
    except Exception as ex:
        print(ex)
    return respuesta
    
def registrar_speed_test_call(properties,usuario,ap_id,wk_flow_id,fecha_solicitud):
    try:
        database = properties['DB_STR_CONNECTION'].split('jdbc:mysql://')[1].split("/")[1].split("?")[0]
        server= properties['DB_STR_CONNECTION'].split('jdbc:mysql://')[1].split(":")[0]
        mydb = mysql.connector.connect(host=server,user=properties['DB_USER'],password=properties['DB_PWD'], database=database)
        strSql = "INSERT INTO speed_test_call(usuario,ap_id,workflow_process_id,fecha,estado,fecha_solicitud) VALUES('{0}','{1}','{2}',sysdate(),'{3}','{4}');".format(usuario,ap_id,wk_flow_id,'registro',fecha_solicitud);
        mycursor = mydb.cursor()
        mycursor.execute(strSql)
        mydb.commit()
    except Exception as e:
        print(e)
        
def get_execute_and_return_pid_body(ap_id):
    body_str = """<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:clar="www.claro.com.co">
        <soapenv:Header/>
        <soapenv:Body>
            <clar:ExecuteAndReturnPID>
                <!--Optional:-->
                <clar:APListIDs>
                    <!--Zero or more repetitions:-->
                    <clar:int>{0}</clar:int>
                </clar:APListIDs>
                <!--Optional:-->
                <clar:UserEmail>florezja@globalhitss.com</clar:UserEmail>
            </clar:ExecuteAndReturnPID>
        </soapenv:Body>
        </soapenv:Envelope>""".format(ap_id)
    return body_str
    
def get_search_result_from_soap(url,body,name_return):
    try:
        headers = {'content-type': 'text/xml'}
        binary_data = body.encode('utf-8')
        req = urllib2.Request(url, binary_data, headers)
        response = urllib2.urlopen(req,context=ssl._create_unverified_context())
        data = response.read()
        dom_c = xml.dom.minidom.parseString(data)
        root = dom_c.firstChild
        search_result = root.getElementsByTagName(name_return)[0]
        return search_result
    except urllib2.HTTPError as e:
        print(" -- Error --- "*2)
        print("Url url:{0}   body:{1} name_return {2} ".format(url,body,name_return))
        resp =   e.read()
        print(resp)
        print(e)
    return None
def get_value_from_element(search_result,name_element):
    element = search_result.getElementsByTagName(name_element)[0]
    return subs_value_from_xmltag(element.toxml())
def subs_value_from_xmltag(valor):
    if valor.count(">") > 1:
            return valor.split(">")[1].split("<")[0]
    else:
        return ""    
def read_properties(file_path):
    separator = "="
    keys = {}
    with open(os.path.join(sys.path[0], file_path), "r") as f:
        for line in f:
            if separator in line:
                name, value = line.split(separator, 1)
                keys[name.strip()] = value.strip()
    return keys        
if __name__ == '__main__':
    properties=read_properties("MinticAutoatencion.properties")
    if(existe_llamada_anterior(properties,usuario,ap_id) ):
        print("Existe")
    else:
        print("LLama uno nuevo")
        main(properties,usuario,ap_id)

