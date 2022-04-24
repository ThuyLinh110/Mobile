N = int(input())
out=[]
for _ in range(N):
    a, b = map(int, input().split())
    out.append(a+b)
for i in range(N):
    print(out[i])