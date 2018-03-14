def dfs(start, paths, visited):
	if start not in dp:
		dp[start] = paths
		for dest in roads[start]:
			dp[start] += 1 if dest == 1 else (0 if dest in visited else dfs(dest, paths, visited | {dest}))
	return dp[start]


input = __import__("sys").stdin.readline
dp = {}
n, m = map(int, input().split())
roads = __import__("collections").defaultdict(list)
for _ in xrange(m):
	a, b = map(int, input().split())
	roads[a - 1].append(b - 1)
print(str(dfs(0, 0, {0}))[-9:])