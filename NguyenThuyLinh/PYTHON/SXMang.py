n=int(input())
arr1 = list(map(lambda x: int(x) , input().split()))
arr1.sort()
for x in arr1: print(x, end=" ")
