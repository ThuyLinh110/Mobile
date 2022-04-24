# Dau hieu chia het 45: chia het 9 va 5  
def TongChuSo(n):
    sum=0
    for i in n:
        sum+=int(i)
    return sum
def ChiaHet(n):
    st1=""
    if TongChuSo(n)%9==0:
        if ("5" in n) or ("0" in n):
            st="".join(sorted(n, reverse=True))
            if ("5" in n) and ("0" not in n) :
                index5 = st.find("5")
                for i in range(index5):
                    st1+=st[i]
                for i in range(index5,len(st)-1):
                    st1+=st[i+1]          
                st1+="5"
                return st1
            return st
            
    return st1
n=input()
if ChiaHet(n)!="":
    print(ChiaHet(n))
else:
    print("-1")