n = int(__import__("sys").stdin.readline())
arr = map(int, __import__("sys").stdin.read().split())
adj = {}
ll = [[0] + range(n), [0] + range(2, n + 1) + [0]]
for i in reversed(arr):
	adj[i] = ll[0][i], ll[1][i]
	ll[1][ll[0][i]] = ll[1][i]
	ll[0][ll[1][i]] = ll[0][i]
depth = [-1] + [0] * n
out = 0
for i in arr:
	depth[i] = max(depth[adj[i][0]], depth[adj[i][1]]) + 1
	out += depth[i]
	print(out)