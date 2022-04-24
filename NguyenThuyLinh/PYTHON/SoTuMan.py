
def SoChuSo(n):
    count=0
    while(n!=0):
        n=n//10
        count+=1
    return count

def SoTuMan(n):
    numOfDigits = SoChuSo(n)
    nSum=0
    nTemp=n
    while (nTemp !=0):
        nRem = nTemp %10
        nSum+= (nRem ** numOfDigits)
        nTemp=nTemp//10
    if (nSum== n):
        print("YES")
    else:
        print("NO")

n = int(input())
SoTuMan(n)

