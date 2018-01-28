def dfs(x, y):
	if grid[y][x] == "N":
		for yy in xrange(y - 1, -1, -1):
			if grid[yy][x] != ".":
				dfs(x, yy)
	elif grid[y][x] == "S":
		for yy in xrange(y + 1, gy):
			if grid[yy][x] != ".":
				dfs(x, yy)
	elif grid[y][x] == "W":
		for xx in xrange(x - 1, -1, -1):
			if grid[y][xx] != ".":
				dfs(xx, y)
	elif grid[y][x] == "E":
		for xx in xrange(x + 1, gx):
			if grid[y][xx] != ".":
				dfs(xx, y)
	grid[y][x] = "."
	print("({},{})".format(y, x))


input = __import__("sys").stdin.readline
__import__("sys").setrecursionlimit(2147483647)
gy, gx = map(int, input().split())
grid = [list(input()) for _ in xrange(gy)]
for y in xrange(gy):
	for x in xrange(gx):
		if grid[y][x] != ".":
			dfs(x, y)