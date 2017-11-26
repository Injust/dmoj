input = __import__("sys").stdin.readline
grid = []
tallest = 0
distance = 9999
y, x = map(int, input().split())
for _ in xrange(y):
	a = list(map(int, input().replace(".", "0").replace("X", "-1").split()))
	if -1 in a:
		start = a.index(-1), _
		a[start[0]] = 0
	tallest = max(tallest, max(a))
	grid.append(a)
tree = start
for yy in xrange(y):
	for xx in xrange(x):
		if grid[yy][xx] == tallest:
			d = (start[0] - xx) ** 2 + (start[1] - yy) ** 2
			if d < distance:
				distance = d
				tree = (xx, yy)
queue = __import__("collections").deque([(start[0], start[1], 0, 0)])
visited = set([start])
cost = {start: (0, 0)}
while queue:
	xx, yy, s, t = queue.popleft()
	for xxx, yyy in [(xx + 1, yy), (xx - 1, yy), (xx, yy + 1), (xx, yy - 1)]:
		if 0 <= xxx < x and 0 <= yyy < y and ((xxx, yyy) not in visited or cost[(xxx, yyy)] > (s + grid[yyy][xxx], t + (grid[yyy][xxx] > 0))):
			queue.append((xxx, yyy, s + grid[yyy][xxx], t + (grid[yyy][xxx] > 0)))
			visited.add((xxx, yyy))
			cost[(xxx, yyy)] = s + grid[yyy][xxx], t + (grid[yyy][xxx] > 0)
print(cost[tree][1] - 1)