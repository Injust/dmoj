input = __import__("sys").stdin.readline
n = int(input())
paths = [[-1] * n for _ in xrange(n)]
buy = {}
for _ in xrange(int(input())):
	x, y, c = map(int, input().split())
	paths[x - 1][y - 1] = paths[y - 1][x - 1] = c
for _ in xrange(int(input())):
	z, p = map(int, input().split())
	buy[z - 1] = p
queue = [(0, int(input()) - 1)]
cost = [0] + [-1] * (n - 1)
out = 99999999
__import__("heapq").heapify(queue)
while queue:
	already, at = __import__("heapq").heappop(queue)
	if already > out:
		break
	out = at in buy and min(buy[at] + already, out) or out
	for dest, add in enumerate(paths[at]):
		if ~add and (not ~cost[dest] or already + add < cost[dest]):
			cost[dest] = already + add
			__import__("heapq").heappush(queue, (already + add, dest))
print(out)