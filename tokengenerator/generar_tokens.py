from oauthlib.oauth2 import BackendApplicationClient
from requests_oauthlib import OAuth2Session
import json
import ssl
import datetime 
import sys
import os
def read_properties(file_path):
    separator = "="
    keys = {}
    with open(os.path.join(sys.path[0], file_path), "r") as f:
        for line in f:
            if separator in line:
                name, value = line.split(separator, 1)
                keys[name.strip()] = value.strip()
    return keys
def main(properties):
    #servidor RS
    json_1 = open(properties["PATH_CRD_RS"])
    token_json = json.load(json_1)
    access_token_url =  properties["URL_TK_RS"]
    client = BackendApplicationClient(client_id=token_json['client_id'])
    oauth = OAuth2Session(client=client)
    token = oauth.fetch_token(token_url=access_token_url, client_id=token_json['client_id'], client_secret=token_json['client_secret'], verify=ssl.CERT_NONE)
    access_tokenrs = token['access_token']
    json_1 = open(properties["PATH_CRD_AP1"])
    token_json = json.load(json_1)
    access_token_url =  properties["URL_TK_AP1"]
    client = BackendApplicationClient(client_id=token_json['client_id'])
    oauth = OAuth2Session(client=client)
    token = oauth.fetch_token(token_url=access_token_url, client_id=token_json['client_id'], client_secret=token_json['client_secret'], verify=ssl.CERT_NONE)
    access_token1 = token['access_token']
    #servidor access point 2
    json_1 = open(properties["PATH_CRD_AP2"])
    token_json = json.load(json_1)
    access_token_url =  properties["URL_TK_AP2"]
    client = BackendApplicationClient(client_id=token_json['client_id'])
    oauth = OAuth2Session(client=client)
    token = oauth.fetch_token(token_url=access_token_url, client_id=token_json['client_id'], client_secret=token_json['client_secret'], verify=ssl.CERT_NONE)
    access_token2 = token['access_token']
    dt_tk = datetime.datetime.now().strftime("%Y-%m-%dT%H:%M:%S%z")
    f = open(properties["PATH_TOKENS"], "w")
    f.write("{},{},{},{}".format(access_tokenrs,access_token1,access_token2,dt_tk))
    f.close()
if __name__ == '__main__':                               
    properties=read_properties("MinticAutoatencion.properties")
    main(properties)
