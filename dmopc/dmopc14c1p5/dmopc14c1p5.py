input = __import__("sys").stdin.readline
ybound, xbound = map(int, input().split())
start = tuple(map(int, input().split()))
office = tuple(map(int, input().split()))
grid = [list(input()) for _ in xrange(ybound)]
for _ in xrange(int(input())):
	y, x = map(int, input().split())
	grid[y][x] = "T"
teleporter = -1
mainoffice = -1
queue = __import__("collections").deque([(start[0], start[1], 0)])
visited = set([(start[0], start[1])])
while queue:
	y, x, steps = queue.popleft()
	if not ~teleporter and grid[y][x] == "T":
		teleporter = steps
	elif y == office[0] and x == office[1]:
		mainoffice = steps
		break
	for yy, xx in (y + 1, x), (y - 1, x), (y, x + 1), (y, x - 1):
		if 0 <= yy < ybound and 0 <= xx < xbound and (yy, xx) not in visited and grid[yy][xx] != "X":
			visited.add((yy, xx))
			queue.append((yy, xx, steps + 1))
print(~teleporter and teleporter <= mainoffice and mainoffice - teleporter or 0)
