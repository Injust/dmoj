input = __import__("sys").stdin.readline
correct = input().strip()
out = 99999999
for _ in xrange(int(input())):
	accuracy = 0
	words = input().split()[1:]
	for word in words:
		grid = [range(len(word) + 1), [0] * (len(word) + 1)]
		for i in xrange(len(correct)):
			for j in xrange(len(word)):
				grid[i & 1 ^ 1][j + 1] = (grid[i & 1][j] if j else i) if correct[i] == word[j] else min(grid[i & 1][j + 1], grid[i & 1 ^ 1][j] if j else i + 1, grid[i & 1][j] if j else i) + 1
		accuracy += grid[i & 1 ^ 1][-1]
	out = min(out, accuracy / float(len(words)))
print(out)