import re
n = int(input())
for _ in range(n):
    a=input()
    patternn="[+-]?([0-9]*)?[.][0-9]*"
    if len(a)!=0 and len(a)!=1:
        if(re.fullmatch(patternn,a)):
            print(True)
        else:
            print(False)
    else:
        print(False)