input = __import__("sys").stdin.readline
top = 0
w, h, n = map(int, input().split())
g = [[0] * (w + 1) for _ in xrange(h + 1)]
for y in xrange(1, h + 1):
    row = map(int, input().split())
    for x in xrange(w):
        g[y][x + 1] = row[x] + g[y][x] + g[y - 1][x + 1] - g[y - 1][x]
for x2 in xrange(1, w + 1):
    for x1 in xrange(x2):
        length = n / (x2 - x1)
        top = max([top] + list(g[y2][x2] + g[y2 - length][x1] - g[y2][x1] - g[y2 - length][x2] for y2 in xrange(length, h + 1)))
print(top)