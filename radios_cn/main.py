import json
import csv
import ssl
import requests
from oauthlib.oauth2 import BackendApplicationClient
from requests_oauthlib import OAuth2Session
import datetime, time

# Limpia el CSV
f = open('CN_RADIOS.csv', 'w')
writer = csv.writer(f)
writer.writerow('')
f.close()

# Ubica las credenciales de la API y solicita el token
json_1 = open("./credentials/rs1.json")
token_json = json.load(json_1)
access_token_url = "https://prycnmrs1.claro.net.co/api/v2/access/token"
# Abre el token y lo envía al cnmaestro para tratar la API
client = BackendApplicationClient(client_id=token_json['client_id'])
oauth = OAuth2Session(client=client)
token = oauth.fetch_token(token_url=access_token_url, client_id=token_json['client_id'], client_secret=token_json['client_secret'], verify=ssl.CERT_NONE)
# Token
access_token1 = token['access_token']
print("Token RS1: " + access_token1)
api_call_headers = {'Authorization': 'Bearer ' + access_token1}

device_data_rs1 = requests.get("https://prycnmrs1.claro.net.co/api/v2/devices/", headers=api_call_headers, verify=False, params={"limit":0}) #, "type":'wifi-enterprise'})
# print(device_data_rs1.text)

# Carga la información obtenida a un JSON
csvhead = """"Description","Device Type","Device_Name","IP Address","IPv6 Address","MAC","Network","Onboard Date","Serial_Number","Site","Software Version","Status","Status_Time","Status_Time_Seconds","Model","Managed_Account","Site_Address","Duration"\n"""

data = device_data_rs1.json()
print(data.keys())

for device in data['data']:
    try:
        desc = device['description']
    except KeyError:
        desc = ""
    try:
        tow = device['tower']
    except:
        tow = ""
    try:
        tiempo_stat = datetime.timedelta(seconds=int(device['status_time']))
    except KeyError:
        tiempo_stat = 0
    if device['managed_account'] == '':
        managed_account = "Base Infrastructure"
    else:
        managed_account = device['managed_account']
    if device['status'] != "onboarding":
        if desc != None:
            csvhead += """"{desc}","{type}","{name}","{ip}","N/A","{mac}","{network}","{reg_date}","{msn}","{tow}","{software_version}","{status}","{tiempo_stat}","{seg}","{typ}","{managed_account}"\n""".format(
                desc=desc, type=device['product'], name=device['name'], ip=device['ip'], mac=device['mac'],
                network=device['network'], reg_date=device['registration_date'], msn=device['msn'], tow=tow, software_version=device['software_version'],
                status=device['status'], tiempo_stat=tiempo_stat, seg=device['status_time'], typ=device['type'], 
                managed_account=managed_account)
        else:
            csvhead += """"{desc}","{type}","{name}","{ip}","N/A","{mac}","{network}","{reg_date}","{msn}","{tow}","{software_version}","{status}","{tiempo_stat}","{seg}","{typ}","{managed_account}"\n""".format(
                desc="", type=device['product'], name=device['name'], ip=device['ip'], mac=device['mac'],
                network=device['network'], reg_date=device['registration_date'], msn=device['msn'], tow=tow, software_version=device['software_version'],
                status=device['status'], tiempo_stat=tiempo_stat, seg=device['status_time'], typ=device['type'],
                managed_account=managed_account)

with open('CN_RADIOS_01.csv', 'w', encoding='utf-8') as f:
    f.write(csvhead)
print("Done!")