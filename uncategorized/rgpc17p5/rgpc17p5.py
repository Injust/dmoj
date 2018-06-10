correct, target = __import__("sys").stdin.read().split("\n")[1:3]
grid = [list(xrange(len(target))), [0] * len(target)]
for i in xrange(len(correct)):
    for j in xrange(len(target) - 1):
        grid[i & 1 ^ 1][j + 1] = (grid[i & 1][j] if j else i) if correct[i] == target[j] else min(grid[i & 1][j + 1], grid[i & 1 ^ 1][j] if j else i + 1, grid[i & 1][j] if j else i) + 1
print(sum(grid[i & 1 ^ 1]))