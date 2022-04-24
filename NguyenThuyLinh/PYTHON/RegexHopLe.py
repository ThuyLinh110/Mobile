import re
N = int(input())
out=[]
for _ in range(N):
    try:
        out.append(bool(re.compile('r'+'"'+input()+'"')))
    except:
        out.append(False)
for i in range(N):
    print(out[i])