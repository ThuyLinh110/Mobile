def findPaths(maze,n):
    path = [0 for d in range(2*n-1)]
    findPathsUtil(maze,n,0,0,path,0)
     
def findPathsUtil(maze,n,i,j,path,index):	
    if i==n-1:
        for k in range(j,n):
            path[index+k-j] = maze[i][k]
        allPaths.append(path[:])
        return
    if j == n-1:
        for k in range(i,n):
            path[index+k-i] = maze[k][j]
        allPaths.append(path[:])
        return
    path[index] = maze[i][j]
     
    findPathsUtil(maze,  n, i+1, j, path, index+1)
     
    findPathsUtil(maze,  n, i, j+1, path, index+1)
 
allPaths=[]
n=int(input())
maze = []
for i in range(n):
	maze.append(list(map(int,input().split())))
findPaths(maze,n)
s = list(map(lambda arr: sum(arr), allPaths))
m=max(s)
print(m,s.count(m))