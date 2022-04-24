def KChia(n,k):
    # so thu k khong chia het cho n
    i=0
    j=1
    while i<=k:
        if j % n !=0:
            i+=1
        j+=1
    return j
N = int(input())
out=[]
for _ in range(N):
    a, b = map(int, input().split())
    out.append(KChia(a,b))
for i in range(N):
    print(out[i])