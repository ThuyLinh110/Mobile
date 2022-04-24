t=int(input())
out=[]
for _ in range(t):
    n= int(input())
    arr = list(map(int, input().split()))
    out.append((3*sum(set(arr)) -sum(arr))//2)
print(out)
