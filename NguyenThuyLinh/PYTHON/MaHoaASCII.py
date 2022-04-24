def MaHoa(str):
    i=0
    st=""
    while (i<len(str)):
        if int(str[i])>=6 and int(str[i]) <=9:
            st+=chr(int(str[i:i+2]))
            i+=2
        elif int(str[i]) ==1:
            st+=chr(int(str[i:i+3]))
            i+=3
    return st

a=input()
print(MaHoa(a))
