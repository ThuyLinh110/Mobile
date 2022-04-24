N=int(input())

def Fibo(N):
    arr=[]
    if N==0:
        return arr
    arr.append(0)
    if N==1:
        return arr  
    arr.append(1)
    for i in range(2,N):
        arr.append(arr[i-1] + arr[i-2])
    return list(map(lambda x: x**3 , arr))
print(Fibo(N))
