input = __import__("sys").stdin.readline
paths = __import__("collections").defaultdict(list)
n, m = map(int, input().split())
for _ in xrange(m):
	i, j = map(int, input().split())
	paths[i - 1].append(j - 1)
prob = [1.0] + [0] * (n - 1)
for i in xrange(n):
	if paths[i]:
		for dest in paths[i]:
			prob[dest] += prob[i] / len(paths[i])
	else:
		print(prob[i])