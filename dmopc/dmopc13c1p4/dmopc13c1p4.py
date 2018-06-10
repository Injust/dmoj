input = __import__("sys").stdin.readline
for _ in xrange(int(input())):
    x, y = map(int, input().split())
    grid = []
    start = None
    length = 60
    for yy in xrange(y):
        a = list(input())
        grid.append(a)
        if start is None and "C" in a:
            start = a.index("C"), yy
    queue = __import__("collections").deque([(start[0], start[1], 0)])
    while queue:
        xx, yy, le = queue.popleft()
        if grid[yy][xx] == "W":
            length = min(length, le)
        elif le < 59 and grid[yy][xx] != "X":
            grid[yy][xx] = "X"
            for xxx, yyy in (xx + 1, yy), (xx - 1, yy), (xx, yy + 1), (xx, yy - 1):
                if 0 <= xxx < x and 0 <= yyy < y and grid[yyy][xxx] != "X":
                    queue.append([xxx, yyy, le + 1])
    print(length if length < 60 else "#notworth")