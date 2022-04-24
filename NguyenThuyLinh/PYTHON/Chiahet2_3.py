# n = int(input())
# count =0
# for i in range(1,n**2+1):
#     if i%2 ==0 or i%3==0:
#         count+=1
# print(count)


from math import gcd
def countNumbers(X, Y, N):
      
    # Count total number divisible by X
    divisibleByX = int(N / X)
  
    # Count total number divisible by Y
    divisibleByY = int(N / Y)
  
    # Count total number divisible 
    # by either X or Y
    LCM = int((X * Y) / gcd(X, Y))
    divisibleByLCM = int(N / LCM)
    divisibleByXorY = (divisibleByX + 
                       divisibleByY - 
                       divisibleByLCM)
  
    # Count total numbers divisible by 
    # X but not Y
    # divisibleByXnotY = (divisibleByXorY - 
    #                     divisibleByY)
  
    return divisibleByXorY
  
# Driver Code
if __name__ == '__main__':
    n,a,b= map(int, input().split())

    print(countNumbers(a,b, n))


