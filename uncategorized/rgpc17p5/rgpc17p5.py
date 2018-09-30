correct, target = __import__("sys").stdin.read().split("\n")[1:3]
grid = [range(len(target)), [0] * len(target)]
for i in xrange(len(correct)):
	for j in xrange(len(target) - 1):
		grid[i & 1 ^ 1][j + 1] = correct[i] == target[j] and (j and grid[i & 1][j] or i) or min(grid[i & 1][j + 1], j and grid[i & 1 ^ 1][j] or i + 1, j and grid[i & 1][j] or i) + 1
print(sum(grid[i & 1 ^ 1]))