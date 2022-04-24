
def move(S, i, m, n):
    # Up
    if i == 0:
        if S[0] > 0:
            if maze[S[0] - 1][S[1]] == '.':
                return S[0] - 1, S[1]
    # Down
    if i == 1:
        if S[0] < m - 1:
            if maze[S[0] + 1][S[1]] == '.':
                return S[0] + 1, S[1]
    # Left
    if i == 2:
        if S[1] > 0:
            if maze[S[0]][S[1] - 1] == '.':
                return S[0], S[1] - 1
    # Right
    if i == 3:
        if S[1] < n - 1:
            if maze[S[0]][S[1] + 1] == '.':
                return S[0], S[1] + 1
    return None


m, n = map(int, input().split())
maze = []
for i in range(m):
	maze.append(list(input()))

start = (0, 0)
goal = (m-1, n-1)

count = -1

Open = [(start, 0, None)]
Closed = {start}

while Open:
	O_TT = Open.pop(0)
	O = O_TT[0]

	if O == goal:
		if count == -1:
			count = O_TT[1]
		elif count > O_TT[-1]:
			count = O_TT[-1]

	for i in range(4):
		child = move(O, i, m, n)
		if child and child not in Closed:
			Open.append((child, O_TT[1] + 1, O_TT))
			Closed.add(child)

print(count)