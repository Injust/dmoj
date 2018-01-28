input = __import__("sys").stdin.readline
n = int(input())
cols = [[] for _ in xrange(n)]
rowFreq = [[0] * n for _ in xrange(3)]
grid = [map(int, input().split()) for y in xrange(3)]
for y, row in enumerate(grid):
	for x, val in enumerate(row):
		cols[val - 1].append(x)
		rowFreq[y][val - 1] += 1
queue = [x for x in xrange(n) if not (rowFreq[1][x] and rowFreq[2][x])]
deleted = [False] * n
out = 0
while queue:
	target = queue.pop()
	for x in cols[target]:
		if not deleted[x]:
			for y in xrange(3):
				val = grid[y][x] - 1
				rowFreq[y][val] -= 1
				if not rowFreq[y][val]:
					queue.append(val)
			deleted[x] = True
			out += 1
print(out)