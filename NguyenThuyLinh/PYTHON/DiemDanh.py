from collections import defaultdict
N = int(input())
d =new_dictionary = defaultdict(list)
c=0

for _ in range(N):
    word, count =  input().split()
    if word in d :
        d[word].append(count)
    else:
        d[word] =[]
        d[word].append(count)

for key in list(d.keys()):
    if len(set(d[key])) >=2:
        c+=1
print(c)