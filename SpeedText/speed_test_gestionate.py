
import ssl
import requests
import sys
import os

import urllib.request as urllib2
import xml.etree.ElementTree as ET
import xml.dom.minidom

print("Inicio")

try:
    print(*sys.argv)
    print(len(sys.argv))
    print(sys.argv[0])
    id_beneficiario = '10494'
except Exception as e:
	raise Exception('Inavlid parameter. Error: ' + str(e))
	



def main(id_beneficiario):
    print("Inicia la consulta para :",id_beneficiario)
    properties=read_properties("MinticAutoatencion.properties")
    #Buscar ap_id
    url=properties["URL_ManageAPSearching"]
    body_str = get_search_ap_by_text_body(id_beneficiario)
    result_soap = get_search_result_from_soap(url,body_str,'SearchAPResultObject')
    ap_id = get_value_from_element(result_soap,'ap_id')
    
    #Registrar trabajo
    print("Ap_id",ap_id)
    url = properties["URL_ExecuteAndReturnPID"]
    body_str = get_search_ap_by_text_body(ap_id)
    result_soap = get_search_result_from_soap(url,body_str,'ExecuteAndReturnPIDResult')
    workflow_tracking_id = get_value_from_element(result_soap,'WorkflowTrackingID')
    process_id = get_value_from_element(result_soap,'ProcessID')
    #   aqui voy
   
   
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
def get_search_result_from_soap(url,body,name_return):
    headers = {'content-type': 'text/xml'}
    binary_data = body.encode('utf-8')
    req = urllib2.Request(url, binary_data, headers)
    response = urllib2.urlopen(req,context=ssl._create_unverified_context())
    data = response.read()
    dom_c = xml.dom.minidom.parseString(data)
    root = dom_c.firstChild
    search_result = root.getElementsByTagName(name_return)[0]
    return search_result
def get_value_from_element(search_result,name_element):
    element = search_result.getElementsByTagName(name_element)[0]
    return element.toxml().split(">")[1].split("<")[0]
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
    print(id_beneficiario)
    main(id_beneficiario)
