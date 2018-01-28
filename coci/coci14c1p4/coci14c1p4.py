def dfs(accuser, mobster):
	if accuser not in visited:
		visited.add(accuser)
		global out
		out += mobster
		accusations[accuse[accuser]] -= 1
		if mobster or not accusations[accuse[accuser]]:
			dfs(accuse[accuser], not mobster)


input = __import__("sys").stdin.readline
n = int(input())
accuse = [0] * n
accusations = [0] * n
for accuser in xrange(n):
	accused = int(input()) - 1
	accuse[accuser] = accused
	accusations[accused] += 1
visited = set()
out = 0
for accuser in xrange(n):
	if not accusations[accuser]:
		dfs(accuser, True)
for accuser in xrange(n):
	dfs(accuser, False)
print(out)