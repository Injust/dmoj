import heapq
input = __import__("sys").stdin.readline
k, n, m = map(int, input().split())
paths = [[] for _ in xrange(n)]
for _ in xrange(m):
	a, b, t, h = map(int, input().split())
	paths[a - 1].append((b - 1, t, h))
	paths[b - 1].append((a - 1, t, h))
a, b = map(int, input().split())
cost = {(a - 1, 0): 0}
queue = [(0, 0, a - 1)]
heapq.heapify(queue)
while queue:
	time, dmg, at = heapq.heappop(queue)
	if at == b - 1:
		print(time)
		break
	for dest, t, d in paths[at]:
		if dmg + d < k and ((dest, dmg + d) not in cost or cost[(dest, dmg + d)] > time + t):
			cost[(dest, dmg + d)] = time + t
			heapq.heappush(queue, (time + t, dmg + d, dest))
else:
	print(-1)