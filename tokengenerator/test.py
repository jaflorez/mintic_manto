import datetime 

d = datetime.datetime.now()
d1 = d.strftime("%Y-%m-%dT%H:%M:%S%z")
print(d1)