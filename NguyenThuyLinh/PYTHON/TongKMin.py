n, k = map(int, input().split())
a= input().split()
lst = list(map(lambda x: int(x) if x.isdigit() else 0, a))
lst.sort()
sum=0
for i in range(k):
    sum+=lst[i]
print(sum)
