gio,phut,giay,m= map(int, input().split())
giay+=m
while (giay >=60):
    phut+=1
    giay-=60
while (phut>=60):
    gio+=1
    phut-=60
while (gio >=12):
    gio-=12

print(str(gio)+" "+str(phut)+" "+str(giay))