def dfs(tree, num, weight):
	if out[tree] is None:
		out[tree] = [num, weight]
		map(lambda i: out.__setitem__(tree, map(sum, zip(out[tree], dfs(i[0], cherries[i[0]], i[1])))), paths[tree])
		global good
		good += out[tree][0] >= c and out[tree][1] <= k and bool(tree)
	return out[tree]


input = __import__("sys").stdin.readline
__import__("sys").setrecursionlimit(2147483647)
n, c, k = map(int, input().split())
cherries = map(int, input().split())
paths = __import__("collections").defaultdict(list)
for _ in xrange(n - 1):
	x, y, z = map(int, input().split())
	paths[x - 1].append((y - 1, z))
out = [None] * n
good = 0
dfs(0, 0, 0)
print(good)