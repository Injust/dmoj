input = __import__("sys").stdin.readline
c, r, d = map(int, input().split())
roads = __import__("collections").defaultdict(list)
weight = [99999999] + [0] * (c - 1)
for _ in xrange(r):
	x, y, w = map(int, input().split())
	roads[x - 1].append((y - 1, w))
	roads[y - 1].append((x - 1, w))
need = [int(input()) - 1 for _ in xrange(d)]
queue = [(-99999999, 0)]
__import__("heapq").heapify(queue)
while queue:
	_, at = __import__("heapq").heappop(queue)
	for dest, add in roads[at]:
		if min(add, weight[at]) > weight[dest]:
			weight[dest] = min(add, weight[at])
			__import__("heapq").heappush(queue, (-weight[dest], dest))
print(min(weight[dest] for dest in need))