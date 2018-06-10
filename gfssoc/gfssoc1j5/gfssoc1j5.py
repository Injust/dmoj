input = __import__("sys").stdin.readline
n, m, t = map(int, input().split())
table, hallways = [[0] * n for _ in xrange(n)], [[] for _ in range(n)]
for _ in xrange(m):
	a, b = map(int, input().split())
	hallways[a - 1].append(b - 1)
for a in xrange(n):
	queue, visited = __import__("collections").deque([(a, 0)]), {a}
	while queue:
		dest, paths = queue.popleft()
		table[a][dest] = paths
		for new in hallways[dest]:
			if new not in visited:
				visited.add(new)
				queue.append((new, paths + 1))
for _ in xrange(int(input())):
	print((lambda d: t * table[d[0] - 1][d[1] - 1] if table[d[0] - 1][d[1] - 1] else "Not enough hallways!")(map(int, input().split())))