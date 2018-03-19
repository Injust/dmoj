input = __import__("sys").stdin.readline
gy = int(input())
gx = int(input())
grid = [[0] * (gx + 1) for _ in xrange(gy)]
for _ in xrange(int(input())):
	x, y, r, b = map(int, input().split())
	for yy in xrange(max(0, y - 1 - r), min(gy, y + r)):
		d = int((r * r - (y - 1 - yy) ** 2) ** 0.5)
		grid[yy][max(0, x - 1 - d)] += b
		grid[yy][min(gx, x + d)] -= b
high = out = 0
for y in xrange(gy):
	b = 0
	for x in xrange(gx):
		b += grid[y][x]
		if b > high:
			out = 1
			high = b
		elif b == high:
			out += 1
print(high)
print(out)