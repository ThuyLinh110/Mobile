import re
s=input()
s1=input()
print(len(re.findall('(?='+s1+')',s)))
