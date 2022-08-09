import sys

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


def main():
    pass


if __name__ == '__main__':
    ShhCx, PayloadDownload, PayloadUpload = sshCommand()
    main(ShhCx,PayloadDownload,PayloadUpload)
