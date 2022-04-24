# n,m,p=map(int,input().split())
# arr1=list(map(int, input().split()))
# arr2=list(map(int, input().split()))
# arr3=list(map(int, input().split()))
# i=0
# j=0
# k=0
# s1=sum(arr1)
# s2=sum(arr2)
# s3=sum(arr3)

# while (s1!=s2 and s2!=s3 and s3!=s1):
#     if (s1>s2):
#         s1-=arr1[i]
#         i+=1
#     if (s2>s3):
#         s2-=arr2[j]
#         j+=1
#     if(s3>s1):
#         s3-=arr3[k]
#         k+=1
# print(s1)




def check(a,b,c):
    sum1=sum(a)
    sum2=sum(b)
    sum3=sum(c)
    while(len(a)>0 and len(b)>0 and len(c)>0): 
        if(sum1==sum2 and sum2==sum3):
            print(sum1)
            return
        if(sum1>=sum2 and sum1>=sum3): 
            sum1-=a.pop(0)              
        if(sum2>=sum1 and sum2>=sum3): 
            sum2-=b.pop(0)     
        if(sum3>=sum1 and sum3>=sum2):
            sum3-=c.pop(0)     
x,y,z=[int(x) for x in input().split()]
a=[]
a.append(list(map(int,input().split()))[:int(x)])
a.append(list(map(int,input().split()))[:int(y)])
a.append(list(map(int,input().split()))[:int(z)])
check(a[0],a[1],a[2])