import re
N = int(input())
check = "^102(17|18|19|20|21)0[0-9]{3,3}"
out=[]
for _ in range(N):
    a =  input()
    out.append(bool(re.fullmatch(check,a)))
for i in range(N):
    print(out[i])

