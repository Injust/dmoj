from heapq import *
data = __import__("sys").stdin.read().split("\n")
v = int(data[0])
paths = [[] for _ in xrange(v)]
cost = [(6000000, 6000000)] * v
for _ in xrange(int(data[1])):
	m, n, d, s = map(int, data[_ + 2].split())
	paths[m - 1].append((n - 1, d * 60 / float(s)))
	paths[n - 1].append((m - 1, d * 60 / float(s)))
queue = [(0, 0, 0)]
heapify(queue)
while queue:
	time, steps, at = heappop(queue)
	for dest, add in paths[at]:
		if (time + add, steps + 1) < cost[dest]:
			cost[dest] = time + add, steps + 1
			heappush(queue, (time + add, steps + 1, dest))
print(cost[-1][1])
print(int(round(cost[-1][0] / 3)))