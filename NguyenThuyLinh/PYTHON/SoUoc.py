# DEM SO UOC
# a =int(input())
# sum=1
# for i in range(2, int(a**0.5)+1):
#     if (a%i ==0):
#         count =0
#         while a%i ==0 :
#             count+=1
#             a//=i
#         sum*=(count+1)
# if a>1:
#     sum*=2       
# print(sum)


# IN CAC UOC
a =int(input())
for i in range(2, int(a**0.5)+1):
    if (a%i ==0):
        print(i,end=' ')
        while a%i ==0 :
            a//=i
        
if a>1:
    print(a)     



