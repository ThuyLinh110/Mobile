

# def removeDuplicates(arr, n):
#     arr.sort()
#     arr1=[]
#     for i in range(n-1):
#         if arr[i] != arr[i+1]:
#             arr1.append(arr[i])
#     arr1.append(arr[-1])
#     return len(arr1),arr1


# n = int(input())
# arr = list(map(lambda x: int(x) , input().split()))
# k,arr1=removeDuplicates(arr,n)
# print(k)
# for i in range(k):
#     print ("%d"%(arr1[i]), end = " ")







def removeDuplicates(arr, n):
    arr.sort()
    arr1=[]
    for i in range(n-1):
        if arr[i] != arr[i+1]:
            arr1.append(arr[i])
    arr1.append(arr[-1])
    return len(arr1),arr1


n = int(input())
arr = list(map(lambda x: int(x) , input().split()))
k,arr1=removeDuplicates(arr,n)
print(k)
for i in range(k):
    print ("%d"%(arr1[i]), end = " ")

