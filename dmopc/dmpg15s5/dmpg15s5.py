input = __import__("sys").stdin.readline
n, m = map(int, input().split())
grid = [[False] * (n + 1) for _ in xrange(n + 1)]
for _ in xrange(m):
	x, y, w, h = map(int, input().split())
	grid[x][y] ^= True
	grid[x][y + h] ^= True
	grid[x + w][y] ^= True
	grid[x + w][y + h] ^= True
for x in xrange(1, n + 1):
	for y in xrange(n + 1):
		grid[x][y] ^= grid[x - 1][y]
for x in xrange(n + 1):
	for y in xrange(1, n + 1):
		grid[x][y] ^= grid[x][y - 1]
out = 0
for x in xrange(n + 1):
	for y in xrange(n + 1):
		out += grid[x][y]
print(out)