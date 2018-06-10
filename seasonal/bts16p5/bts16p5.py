def dfs(tree, num, weight):
	if out[tree] == [0, 0]:
		out[tree] = [num, weight]
		for dest, add in paths[tree]:
			out[tree] = map(sum, zip(out[tree], dfs(dest, cherries[dest], add)))
		global good
		good += bool(out[tree][0] >= c and out[tree][1] <= k and tree)
	return out[tree]


input = __import__("sys").stdin.readline
__import__("sys").setrecursionlimit(2147483647)
n, c, k = map(int, input().split())
cherries = map(int, input().split())
paths = __import__("collections").defaultdict(list)
for _ in xrange(n - 1):
	x, y, z = map(int, input().split())
	paths[x - 1].append((y - 1, z))
out = [[0, 0] for _ in xrange(n)]
good = 0
dfs(0, 0, 0)
print(good)