def drain(x, y):
	filled[y][x] = False
	for dx, dy in (1, 0), (0, 1), (-1, 0), (0, -1):
		0 <= x + dx < gx and 0 <= y + dy < gy and filled[y + dy][x + dx] and drain(x + dx, y + dy)


input = __import__("sys").stdin.readline
for _ in xrange(5):
	gy, gx = map(int, input().split())
	grid = []
	maxh = 0
	for y in xrange(gy):
		grid.append(map(int, input().split()))
		maxh = max(maxh, max(grid[-1]))
	out = 0
	for h in xrange(maxh):
		filled = [[x <= h for x in grid[y]] for y in xrange(gy)]
		for y in xrange(gy):
			if filled[y][0]:
				drain(0, y)
			if filled[y][-1]:
				drain(gx - 1, y)
		for x in xrange(1, gx - 1):
			if filled[0][x]:
				drain(x, 0)
			if filled[-1][x]:
				drain(x, gy - 1)
		out += sum(sum(filled[y]) for y in xrange(gy))
	print(out)