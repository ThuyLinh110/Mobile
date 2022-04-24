N = int(input())
out=[]
for _ in range(N):
    a, b =  input().split()
    try :
        out.append(int(a)//int(b))
    except ZeroDivisionError as e:
        out.append("Error Code: "+str(e))
    except ValueError as e:
        out.append("Error Code: "+str(e))
for i in range(N):
    print(out[i])