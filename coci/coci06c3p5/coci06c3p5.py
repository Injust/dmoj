def dfs(start, paths, visited):
	if start not in dp:
		dp[start] = paths
		for dest in roads[start]:
			dp[start] += dest == 1 or dest in visited and 0 or dfs(dest, paths, visited | {dest})
	return dp[start]


input = __import__("sys").stdin.readline
dp = {}
n, m = map(int, input().split())
roads = __import__("collections").defaultdict(list)
for _ in xrange(m):
	a, b = map(int, input().split())
	roads[a - 1].append(b - 1)
print(str(dfs(0, 0, {0}))[-9:])