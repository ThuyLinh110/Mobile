
M=int(input())
out=[]
for _ in range(M):
    N = int(input())
    res =''
    d =dict()
    for _ in range(N):
        word, count =  input().split()
        if word in d :
            d[word]+=int(count)
        else:
            d[word]+=int(count)
    print(d)
    # st=max(d,key=d.get)
    # res=st+" "+str(d[st])
    # out.append(res)

# for i in out:
#     print(i)