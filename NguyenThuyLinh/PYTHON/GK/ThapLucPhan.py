n = int(input())

s=str(hex(n))[2:]
while(len(s)<8):
    s='0'+s
print(s.upper()[:4]+" "+s.upper()[4:])