n=int(input())
ketQua = ""
if (n==0):
    print(0)
else:
    while(n>0):
        ketQua = str(n%2)+ketQua
        n =n//2
    print(ketQua)