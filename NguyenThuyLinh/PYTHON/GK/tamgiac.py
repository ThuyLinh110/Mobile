arr = list(map(int, input().split()))
a=((arr[0]-arr[2])**2 + (arr[1]-arr[3])**2)**0.5
b=((arr[2]-arr[4])**2 + (arr[3]-arr[5])**2)**0.5
c=((arr[0]-arr[4])**2 + (arr[1]-arr[5])**2)**0.5

if a+b >c and b+c >a and a+c >b :
    print("YES")
else:
    print("NO")
