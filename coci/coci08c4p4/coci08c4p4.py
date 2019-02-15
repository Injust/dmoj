def recurse(x1, x2, y1, y2):
	if x2 - x1 == 1:
		out[y1][x1] = grid[y1][x1]
		return grid[y1][x1] > "0", grid[y1][x1] < "1", 0
	size = x2 - x1 >> 1
	xmid = x1 + size
	ymid = y1 + size
	squares = recurse(x1, xmid, y1, ymid), recurse(xmid, x2, y1, ymid), recurse(x1, xmid, ymid, y2), recurse(xmid, x2, ymid, y2)
	all0 = sum(square[0] for square in squares)
	all1 = sum(square[1] for square in squares)
	cost = 262144
	for a, b, c, d in __import__("itertools").permutations(xrange(4)):
		newcost = squares[a][0] + squares[b][1] + squares[c][2] + squares[d][2]
		if newcost < cost:
			cost = newcost
			best = a, b, c, d
	for dy in xrange(size):
		for dx in xrange(size):
			out[y1 + size * (best[0] >> 1) + dy][x1 + size * (best[0] & 1) + dx] = "0"
			out[y1 + size * (best[1] >> 1) + dy][x1 + size * (best[1] & 1) + dx] = "1"
	return all0, all1, cost


input = __import__("sys").stdin.readline
n = int(input())
grid = [input() for _ in xrange(n)]
out = [[""] * n for _ in xrange(n)]
print(recurse(0, n, 0, n)[2])
print("\n".join("".join(out[i]) for i in xrange(n)))