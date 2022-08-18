import sys
import paramiko
import socket
import re
import time
import _cffi_backend
from datetime import datetime, timedelta

print("Uno")

min_args = 8
if len(sys.argv) < (min_args + 1):
    raise Exception("Invalid number of arguments. This script requires minimum [ " + str(min_args) + " ] arguments")

### Variables
try:
	BWDownloadMbps = float(sys.argv[1].replace(',','.'))
	BWUploadMbps = float(sys.argv[2].replace(',','.'))
	SpeedtestUrl = sys.argv[3]
	APIpAddress = sys.argv[4]
	APUser = sys.argv[5]
	APPassword = sys.argv[6]
	SSHTimeoutSecs = int(sys.argv[7])
	speedtestDurationSecs = int(sys.argv[8])
except Exception as e:
	raise Exception('Inavlid parameter. Error: ' + str(e))
	
paramiko.util.logging.getLogger('paramiko.transport').disabled = True

### Create command for speed test
def sshCommand():
	if BWDownloadMbps <= 12:
		payload_download = 10
		payload_upload = 5
	elif BWDownloadMbps <= 15:
		payload_download = 10
		payload_upload = 5
	elif BWDownloadMbps <= 18:
		payload_download = 20
		payload_upload = 5
	else:
		payload_download = 20
		payload_upload = 5
	
	return "speedtest etsi " + SpeedtestUrl + " " + str(payload_download) + " " + str(payload_upload) + " 10", int(payload_download), int(payload_upload)

### SSH connection
def sshConnection(remoteIP, remoteUSR, remotePWD, timeoutSSH, timeoutBanner, timeoutAuthentication):
    try:
        ssh_cx = paramiko.SSHClient()
        ssh_cx.load_system_host_keys()
        ssh_cx.set_missing_host_key_policy(paramiko.AutoAddPolicy())
        ssh_cx.connect(hostname=remoteIP, username=remoteUSR, password=remotePWD, timeout=timeoutSSH, banner_timeout=timeoutBanner, auth_timeout=timeoutAuthentication)
        return ssh_cx
    except paramiko.ssh_exception.AuthenticationException as e:
        if 'Authentication timeout' in str(e):
            raise Exception("SSH Authentication timeout")
        else:
            raise Exception("SSH Authentication failed")    
    except paramiko.ssh_exception.SSHException as sshException:
        if 'Error reading SSH protocol banner' in str(sshException):
            raise Exception("Error reading SSH protocol banner")
        else:
            raise Exception("Unable to connect over SSH")
    except socket.timeout as socketTimeout:
        raise Exception("Socket timeout: " + str(socketTimeout))
    except socket.error as socketError:
        raise Exception("Socket error: " + str(socketError))    
    except:
        raise Exception("Unable to connect over SSH")

### Execute command
def executeCommand(ssh_cx, commandLine, timeout):
    console = dict()
    console['ex_error'] = False
    try:
        stdin, stdout, stderr = ssh_cx.exec_command(commandLine)
    except Exception as e:
        raise Exception("Error running SpeedTest command: "+str(e))
    start = time.time()
    while time.time() < start + timeout:
        if stdout.channel.exit_status_ready():
            break
        time.sleep(1)
    else:
        raise Exception(f'SpeedTest command timed out!')
    console['stdin'] = stdin
    console['stdout'] = stdout
    console['stderr'] = stderr
            
    if stderr.channel.recv_exit_status() != 0:
        console['ex_error'] = True
        console['ex_error_msg'] = stderr.readlines()
    return console
        
### Parse results
def parseSpeedTestValues(data):
    try:
        speeds = []
        response_split = data.split('Upload:')
        pattern = "([+-]?([0-9]*[.])?[0-9]+)"
        for i in response_split:
            res = re.search(pattern, i)
            speeds.append(res.group())
        return speeds
    except:
        raise Exception("Unable to parse speedtest information")

### Parse results
def parseNetworkValues(data):
    try:
        networkParamValues = []
        response_split = data.split('Jitter:')
        pattern = "([+-]?([0-9]*[.])?[0-9]+)"
        for i in response_split:
            res = re.search(pattern, i)
            networkParamValues.append(res.group())
        return networkParamValues
    except:
        raise Exception("Unable to parse speedtest network parameters information")

### Process result
def returnResult(lines):    
    dl, up, lat, jit = -1.0, -1.0, -1.0, -1.0
    result = dict()
    result_ex = ""
    for l in lines.readlines():
        if l != "":
            result_ex = result_ex + l
    if "Error processing cli command" in result_ex:
        raise Exception(f"SpeedTest command not found")
    try:
        result_ex2 = ""
        result_test = result_ex.splitlines()
        for x in result_test:
            y = x.strip()
            if y.startswith('Latency') or (y.startswith('Download') and y == result_test[-1]):
                result_ex2 = result_ex2 + y.replace('.', ',') + '\n'
                if y.startswith('Latency'):
                    networkvalues = parseNetworkValues(y)
                    lat = float(networkvalues[0])
                    jit = float(networkvalues[1])
                if y.startswith('Download') and y == result_test[-1]:
                    speedvalues = parseSpeedTestValues(y)
                    dl = float(speedvalues[0])
                    up = float(speedvalues[1])
        result['output'] = result_ex2
        result['download'] = dl
        result['upload'] = up
        result['latency'] = lat
        result['jitter'] = jit
        return result
    except:
        raise Exception("Unable to get speedtest results from AP")
        
### Run SpeedTest
def doTest(config):
    try:
        ssh_cx = sshConnection(config['remoteIP'],
                               config['remoteUSR'],
                               config['remotePWD'],
                               config['timeoutSSH'],
                               config['timeoutBanner'],
                               config['timeoutAuthentication'])
        console = executeCommand(ssh_cx, config['commandLine'], config['commandTimeout'])
        lines = console['stdout']        
        result = returnResult(lines)
        ssh_cx.close()
        return result
    except Exception as e:
        raise Exception(f"Error running Speed test: {e}")

def main(ex_command,pl_download,pl_upload):
    config = {
        "remoteIP" : APIpAddress,
        "remoteUSR" : APUser,
        "remotePWD" : APPassword,
        "commandLine" : ex_command,
        "timeoutSSH" : SSHTimeoutSecs,
        "speedtestDurationSecs" : speedtestDurationSecs,
        "exp_dl" : BWDownloadMbps * 1000,
        "exp_ul" : BWUploadMbps * 1000,

        "commandTimeout": 180,
        "timeoutBanner": 30,
        "timeoutAuthentication": 30
    }

    duration = datetime.now() + timedelta(seconds=config['speedtestDurationSecs'])
    expected_download_mbps = float(config['exp_dl'])
    expected_upload_mbps = float(config['exp_ul'])
    time_interval_speedtests = 5  # seconds
    attempts_count = 1

    downloadValues, uploadValues, latencyValues, jitterValues = [], [], [], []
    outputSpeedTest = []
    download, upload, latency, jitter = -1.0, -1.0, -1.0, -1.0
    bestDownload, bestUpload = -1.0, -1.0

    try:
        while datetime.now() < duration:
            if (bestDownload < expected_download_mbps) or (bestUpload < expected_upload_mbps):
                result = doTest(config)
                # print(result['output'])                
                attempts_count = attempts_count + 1
                outputSpeedTest.append(result['output'])
                downloadValues.append(result['download'])
                uploadValues.append(result['upload'])
                latencyValues.append(result['latency'])
                jitterValues.append(result['jitter'])

                bestDownload = max(downloadValues)
                bestUpload = max(uploadValues)

                download = bestDownload
                upload = uploadValues[downloadValues.index(bestDownload)]
                latency = latencyValues[downloadValues.index(bestDownload)]
                jitter = jitterValues[downloadValues.index(bestDownload)]

                time.sleep(time_interval_speedtests)
            else:                
                break

        if (download == -1 or upload == -1):
            raise Exception(
                f"SpeedTest empty response [Download:{download} Upload:{upload} Latency:{latency} Jitter:{jitter}]")

        response = f'{download}|{pl_download}|{upload}|{pl_upload}|{latency}|{jitter}'
        print(response.replace('.', ','))
        sys.exit(0)

    except Exception as e:
        if attempts_count > 1:
            if (download == -1 or upload == -1):
                sys.exit(f'SpeedTest Python Script Error: {e}')
            else:
                response = f'{download}|{pl_download}|{upload}|{pl_upload}|{latency}|{jitter}'
                print(response.replace('.', ','))
                sys.exit(0)            
        else:
            sys.exit(f'SpeedTest Python Script Error: {e}')

if __name__ == '__main__':
    ShhCx, PayloadDownload, PayloadUpload = sshCommand()
    main(ShhCx,PayloadDownload,PayloadUpload)