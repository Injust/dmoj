input = __import__("sys").stdin.readline
gy, gx = map(int, input().split())
grid = [input() for _ in xrange(gy)]
corners = set()
for y in xrange(gy):
	for x in xrange(gx):
		if grid[y][x] == "x":
			if sum(0 <= xx < gx and 0 <= yy < gy and grid[yy][xx] == "x" for xx, yy in ((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1))) < 3:
				corners.add((x, y))
ul = set()
for cx, cy in corners:
	size = 101
	for dx, dy in ((1, 1), (-1, 1), (1, -1), (-1, -1)):
		cx1, cy1 = cx, cy
		cx2, cy2 = cx, cy
		length = 0
		while 0 <= cx1 + dx < gx and 0 <= cy1 < gy and 0 <= cx2 < gx and 0 <= cy2 + dy < gy and grid[cy1][cx1 + dx] == grid[cy2 + dy][cx2] == "x":
			cx1 += dx
			cy2 += dy
			length += 1
		if length:
			size = min(size, length)
			ul.add((cx if ~dx else cx1, cy if ~dy else cy2, length))
	if size == 101:
		ul.add((cx, cy, 0))
for out in ul:
	print out[1] + 1, out[0] + 1, out[2] + 1
if len(ul) == 1:
	print out[1] + 1, out[0] + 1, 1