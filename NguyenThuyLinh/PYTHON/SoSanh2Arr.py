n,m=map(int, input().split())

arr1= list(map(lambda x: int(x) , input().split()))
arr2 = list(map(lambda x: int(x) , input().split()))

arr3=set(arr1) & set(arr2)
print(len(arr3))