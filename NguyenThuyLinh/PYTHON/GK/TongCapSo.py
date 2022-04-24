n,k = map(int, input().split())
arr = list(map(int, input().split()))
def check(arr,n,k):
    for i in range(n):
        z= k -arr[i]
        if z in arr:
            return True
    return False
    
if check(arr,n,k):
    print("YES")
else:
    print("NO")
