import json
import requests
import ssl
from oauthlib.oauth2 import BackendApplicationClient
from requests_oauthlib import OAuth2Session

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