import json
import requests
import ssl
import datetime 
from oauthlib.oauth2 import BackendApplicationClient
from requests_oauthlib import OAuth2Session

def generar_tokens():
    json_1 = open("./credentials/cn1.json")
    token_json = json.load(json_1)
    # External link to the API CN1
    access_token_url = "https://prycnmap1.claro.net.co/api/v2/access/token"
    # Internal link to the API CN1
    # access_token_url = "https://100.123.26.224/api/v2/access/token"
    # Abre el json con las credenciales y lo envía al cnmaestro para tratar la API
    client = BackendApplicationClient(client_id=token_json['client_id'])
    oauth = OAuth2Session(client=client)
    token = oauth.fetch_token(token_url=access_token_url, client_id=token_json['client_id'], client_secret=token_json['client_secret'], verify=ssl.CERT_NONE)
    # Token
    access_token1 = token['access_token']
    # print("Token CN1: " + access_token1)


    json_1 = open("./credentials/cn2.json")
    token_json = json.load(json_1)
    # External link to the API CN2
    access_token_url = "https://prycnmap2.claro.net.co/api/v2/access/token"
    # Internal link to the API CN2
    # ccess_token_url = "https://100.123.26.252/api/v2/access/token"
    # Abre el json con las credenciales y lo envía al cnmaestro para tratar la API
    client = BackendApplicationClient(client_id=token_json['client_id'])
    oauth = OAuth2Session(client=client)
    token = oauth.fetch_token(token_url=access_token_url, client_id=token_json['client_id'], client_secret=token_json['client_secret'], verify=ssl.CERT_NONE)
    # Token
    access_token2 = token['access_token']
    # print("Token CN2: " + access_token1)
    json_1 = open("./credentials/rs1.json")
    token_json = json.load(json_1)
    # External link to the API RS1
    access_token_url = "https://prycnmrs1.claro.net.co/api/v2/access/token"
    # Internal link to the API RS1
    # access_token_url = "https://100.123.26.246/api/v2/access/token"
    # Abre el json con las credenciales y lo envía al cnmaestro para tratar la API
    client = BackendApplicationClient(client_id=token_json['client_id'])
    oauth = OAuth2Session(client=client)
    token = oauth.fetch_token(token_url=access_token_url, client_id=token_json['client_id'], client_secret=token_json['client_secret'], verify=ssl.CERT_NONE)
    # Token
    access_token3 = token['access_token']
    # print("Token RS1: " + access_token3)
    print("Token CN1: " + access_token1)
    print("Token CN2: " + access_token2)
    print("Token RS1: " + access_token3)
    dt_tk = datetime.datetime.now().strftime("%Y-%m-%dT%H:%M:%S%z")
    f = open("./tokens/tokens.txt", "w")
    f.write("{},{},{},{}".format(access_token3,access_token1,access_token2,dt_tk))
    f.close()
def main():
    try:
        print("Cargo")
        f = open("./tokens/tokens.txt", "r")
        data_tk = f.read()
        f.close()
        data = data_tk.split(",")
        dtTk=datetime.datetime.strptime(data[3], "%Y-%m-%dT%H:%M:%S")
        dtNow=datetime.datetime.now()
        dif_dt = dtNow-dtTk 
        print(dif_dt.total_seconds()/(60) )
        if dif_dt.total_seconds()/(60) > 55 :
            print("Genero tokens")
            generar_tokens()            
            f = open("./tokens/tokens.txt", "r")
            data_tk = f.read()
            f.close()
            data = data_tk.split(",")
        print("Cargo url")
        ID_SW_RD = 0
        ID_AP_SR1 = 1
        ID_AP_SR2 = 2
        print("devices")
        api_call_headers = {'Authorization': 'Bearer ' + data[ID_SW_RD]}
        api_call_response = requests.get('https://prycnmrs1.claro.net.co/api/v2/devices', headers=api_call_headers, verify=False)        
        #print(api_call_response.text)
        f = open("./tokens/salida.json", "w")
        f.write(api_call_response.text)
        f.close()

        json_object = json.loads(api_call_response.text)
        header = json_object['paging']
        print(header)
        data_list = json_object['data'] 
        cnt = 0
        
#        for item in data_list:
            #print(type(item))
            #print(item)
         #   print(cnt, item['name'],item['ip'],item['mac'],item['status'],item['type'])
 #           cnt = cnt + 1
            #print("Name : ", item['name'],item['ip'],item['status'],item['mac'],item['parent_mac'])
            #break
            
        #print(header)
        
        print(type(json_object['data']))
        print("--"*20)
        
        
        
        print("switches 00:04:56:46:A4:00" )
        api_call_headers = {'Authorization': 'Bearer ' + data[ID_SW_RD]}
        api_call_response = requests.get('https://prycnmrs1.claro.net.co/api/v2/devices/00:04:56:46:A4:00/statistics?fields=name,status,tower,ip', headers=api_call_headers, verify=False)        
                                         
        print(api_call_response.text)
        print("--"*20)
        
        
        print("Radios 00:04:56:46:A4:00")
        api_call_headers = {'Authorization': 'Bearer ' + data[ID_SW_RD]}
        api_call_response = requests.get('https://prycnmrs1.claro.net.co/api/v2/devices/00:04:56:46:A4:00/statistics?fields=lan_mode_status,lan_speed_status,radio.dl_rssi,radio.dl_snr,name,ap_mac,mac,status,tower', headers=api_call_headers, verify=False)        
        print(api_call_response.text)
        print("--"*20)
        
        
        



        print("RADIO BTS new")
        api_call_headers = {'Authorization': 'Bearer ' + data[ID_SW_RD]}
        api_call_response = requests.get('https://prycnmrs1.claro.net.co/api/v2/devices/00:04:56:46:A4:00/statistics?fields=distance,lan_mode_status,lan_speed_status,name,mac,status,tower', headers=api_call_headers, verify=False)        
        print(api_call_response.text)
        print("--"*20)
        
        print("--AP 1-- "*20)
        print(data[ID_AP_SR1])
        api_call_headers = {'Authorization': 'Bearer ' + data[ID_AP_SR1]}
        api_call_response = requests.get('https://prycnmap1.claro.net.co/api/v2/devices/BC:A9:93:0C:7B:69/statistics?fields=name,mac,status,site', headers=api_call_headers, verify=False)        
        print(api_call_response.text)
        print("--"*20)
        print("--AP 2--")
        api_call_headers = {'Authorization': 'Bearer ' + data[ID_AP_SR2]}
        api_call_response = requests.get('https://prycnmap2.claro.net.co/api/v2/devices/BC:A9:93:0C:7B:69/statistics?fields=name,mac,status,site', headers=api_call_headers, verify=False)        
        print(api_call_response.text)
        print("--"*20)
        
        
        
        

        print("--router cd--")
        print("--"*20)
        
        
        
        
        
        
        
    except Exception as e:
        print(e)
    
if __name__ == '__main__':                               
    #generar_tokens()
    main()
