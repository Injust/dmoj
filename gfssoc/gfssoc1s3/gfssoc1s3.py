def bfs(start):
    yy, xx = start
    dist = {}
    for dest in hiders:
        dist[dest] = 0
    visited = set([start])
    queue = __import__("collections").deque([(yy, xx, 0)])
    while queue:
        yy, xx, steps = queue.popleft()
        if (yy, xx) in dist:
            dist[(yy, xx)] = steps
        for yy, xx in (yy + 1, xx), (yy - 1, xx), (yy, xx + 1), (yy, xx - 1):
            if 0 <= yy < y and 0 <= xx < x and (yy, xx) not in visited and grid[yy][xx] != "X":
                visited.add((yy, xx))
                queue.append((yy, xx, steps + 1))
    return dist


input = __import__("sys").stdin.readline
y, x, t = map(int, input().split())
out = 9999
grid = []
start = None
hiders = []
for _ in xrange(y):
    a = input()
    if start is None and "G" in a:
        start = _, a.find("G")
    b = 0
    while "H" in a[b:]:
        c = a.find("H", b)
        hiders.append((_, c))
        b = c + 1
    grid.append(a)
one = bfs(start)
two = [[0] * t for _ in xrange(t)]
for _ in xrange(t):
    two[_] = bfs(hiders[_])
candidates = list(xrange(t))
for entry in list(__import__("itertools").permutations(candidates)):
    z = one[hiders[entry[0]]]
    for index in xrange(1, t):
        z += two[entry[index - 1]][hiders[entry[index]]]
    out = min(out, z)
print(out)