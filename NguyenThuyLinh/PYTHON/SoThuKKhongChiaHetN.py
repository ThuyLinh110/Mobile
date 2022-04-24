import math
# So Thu K Khong chia het cho n
def kthNonDivisible(N, K):
     
    return K + math.floor((K - 1) / (N - 1))

N = int(input())
out=[]
for _ in range(N):
    a, b = map(int, input().split())
    out.append(kthNonDivisible(a,b))
for i in range(N):
    print(out[i])