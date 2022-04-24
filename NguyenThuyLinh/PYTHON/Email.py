import re
def fun(variable):
    return bool(re.fullmatch(r'^[\w-]+@[a-zA-Z0-9]+\.[a-z]{2,3}$',variable))
inp=[]
N=int(input())
for _ in range(N):
    inp.append(input())
out=list(filter(fun,inp))
out.sort()
print(out)    