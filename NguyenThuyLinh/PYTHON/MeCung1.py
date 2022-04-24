
def isSafe( maze, x, y ):
	
	if x >= 0 and x < N and y >= 0 and y < M and maze[x][y] == '.':
		return True
	
	return False

def solveMaze( maze ):
	
	sol = [ [ '#' for j in range(M) ] for i in range(N) ]
	count=-1

	if solveMazeUtil(maze, 0, 0, sol) == False:
		print(count)
	else :
		for i in sol:
			for j in i:
				print(j," ", end="")
				if j=='.':
					count+=1
			print("")
		print(count)
def solveMazeUtil(maze, x, y, sol):
	
	# if (x, y is goal) return True
	if x == N - 1 and y == M - 1 and maze[x][y]== '.':
		sol[x][y] = '.'
		return True
		
	# Check if maze[x][y] is valid
	if isSafe(maze, x, y) == True:
		# Check if the current block is already part of solution path.
		if sol[x][y] == '.':
			return False
		
		# mark x, y as part of solution path
		sol[x][y] = '.'
		
		# Move forward in x direction
		if solveMazeUtil(maze, x + 1, y, sol) == True:
			return True
			
		# If moving in x direction doesn't give solution
		# then Move down in y direction
		if solveMazeUtil(maze, x, y + 1, sol) == True:
			return True
		
		# If moving in y direction doesn't give solution then
		# Move back in x direction
		if solveMazeUtil(maze, x - 1, y, sol) == True:
			return True
			
		# If moving in backwards in x direction doesn't give solution
		# then Move upwards in y direction
		if solveMazeUtil(maze, x, y - 1, sol) == True:
			return True
		
		# If none of the above movements work then
		# BACKTRACK: unmark x, y as part of solution path
		sol[x][y] = '#'
		return False

# Driver program to test above function
if __name__ == "__main__":
	N,M = map(int, input().split())
	Mat=[]
	for _ in range(N):
		Mat.append(list( input()))		
	solveMaze(Mat)

"""
........#.
######..##
#####..###
####...###
###...#...
..........
"""
