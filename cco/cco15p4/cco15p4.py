def dfs(x, y):
	if grid[y][x] > "V":
		[dfs(xx, y) for xx in xrange(x - 1, -1, -1) if grid[y][xx] > "."]
	elif grid[y][x] > "R":
		[dfs(x, yy) for yy in xrange(y + 1, gy) if grid[yy][x] > "."]
	elif grid[y][x] > "M":
		[dfs(x, yy) for yy in xrange(y - 1, -1, -1) if grid[yy][x] > "."]
	elif grid[y][x] > "D":
		[dfs(xx, y) for xx in xrange(x + 1, gx) if grid[y][xx] > "."]
	grid[y][x] = "."
	print("({},{})".format(y, x))


input = __import__("sys").stdin.readline
gy, gx = map(int, input().split())
grid = [list(input()) for _ in xrange(gy)]
for y in xrange(gy):
	for x in xrange(gx):
		if grid[y][x] != ".":
			dfs(x, y)