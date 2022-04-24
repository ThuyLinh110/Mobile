
# def Key(str):
#     return ord(str)-65

# def MaHoa(st,k):
#     if(ord(st)+k >90):
#         return chr(ord(st)+k-22)

#     return chr(ord(st)+k)

# def KeoChuoi(c,str):
#     i=0
#     s=str[:]
#     while (len(s) < len(c)):
#         s+=str[i]
#         i+=1
#         if (i>=len(str)):
#             i=0
#     return s

# C=input()
# keyy=input()
# key1=KeoChuoi(C,keyy)
# result=''
# for i in range(len(C)):
#     result+=MaHoa(C[i],Key(key1[i]))
# print(result)



chuoi= input()
khoa = input()
for i in range(int(len(chuoi) / len(khoa)) + (len(chuoi) % len(khoa) > 0)):
    khoa += khoa
khoa = khoa[:len(chuoi)]
bang = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
matran = []
for i in range(26):
    matran.append(bang[i:26+i:1]) 
matran = matran[::-1]
result = ''
for i in range(len(chuoi)):
    result += matran[ord(khoa[i]) - 66][ord(chuoi[i]) - 65]
result=result.upper()
print(result)

