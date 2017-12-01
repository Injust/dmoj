input = __import__("sys").stdin.readline
n = int(input())
t = int(input())
lines = []
yexpand = set()
ycompress = {}
for _ in xrange(n):
	x1, y1, x2, y2, f = map(int, input().split())
	lines.append((x1, y1, y2, f))
	lines.append((x2, y1, y2, -f))
	yexpand.update((y1, y2))
lines.sort()
yexpand = sorted(yexpand)
for ind, val in enumerate(yexpand):
	ycompress[val] = ind
state = [0] * len(yexpand)
out = 0
for x in xrange(len(lines)):
	for y in xrange(len(yexpand) - 1):
		out += (state[y] >= t) * (yexpand[y + 1] - yexpand[y]) * (lines[x][0] - lines[x - 1][0])
	for y in xrange(ycompress[lines[x][1]], ycompress[lines[x][2]]):
		state[y] += lines[x][3]
print(out)