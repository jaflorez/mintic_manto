import sys
import os
import ssl
import urllib.request as urllib2
import xml.etree.ElementTree as ET
import xml.dom.minidom
import mysql.connector
if len(sys.argv) < 2:
    raise Exception("Invalid number of arguments. This script requires minimum [ 1 ] arguments")
try:
    id_beneficiario = sys.argv[1]
except Exception as e:
	raise Exception('Invalid parameter. Error: ' + str(e))

def consultar_ap_id(properties,id_beneficiario):
        url=properties["URL_ManageAPSearching"]
        body_str = get_search_ap_by_text_body(id_beneficiario)
        result_soap = get_search_result_from_soap(url,body_str,'SearchAPResultObject')
        ap_id = get_value_from_element(result_soap,'ap_id')
        return ap_id
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
    
def get_search_ap_by_text_body(id_beneficiario):
    body_str = """<?xml version="1.0" encoding="UTF-8"?>
                <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:clar="www.claro.com.co">
                <soapenv:Header/>
                <soapenv:Body>
                    <clar:SearchAPByText>
                        <!--Optional:-->
                        <clar:TextToSearch>{0}</clar:TextToSearch>
                        <clar:MaxRows>50</clar:MaxRows>
                    </clar:SearchAPByText>
                </soapenv:Body>
            </soapenv:Envelope>""".format(id_beneficiario)    
    return body_str
def read_properties(file_path):
    separator = "="
    keys = {}
    with open(os.path.join(sys.path[0], file_path), "r") as f:
        for line in f:
            if separator in line:
                name, value = line.split(separator, 1)
                keys[name.strip()] = value.strip()
    return keys  
def update_centro_digital(properties,id_cd,ap_id):
    try:
        database = properties['DB_STR_CONNECTION'].split('jdbc:mysql://')[1].split("/")[1].split("?")[0]
        server= properties['DB_STR_CONNECTION'].split('jdbc:mysql://')[1].split(":")[0]
        mydb = mysql.connector.connect(host=server,user=properties['DB_USER'],password=properties['DB_PWD'], database=database)
        if len(id_beneficiario) == 5:
            strSql = "update centro_digital set ap_id = {0} where id_beneficiario = '{1}';".format(ap_id,id_cd);
        else:
            strSql = "update centro_digital set ap_id = {0} where id_mintic = '{1}';".format(ap_id,id_cd);
        print(strSql)
        mycursor = mydb.cursor()
        mycursor.execute(strSql)
        mydb.commit()
    except Exception as e:
        print(e)

if __name__ == '__main__':
    try:
        properties=read_properties("MinticAutoatencion.properties")    
        ap_id = consultar_ap_id(properties,id_beneficiario)
        update_centro_digital(properties,id_beneficiario,ap_id)
        sys.exit(ap_id)
    except Exception as e:
        sys.exit("ERR:"+e.__cause__)
        
    
