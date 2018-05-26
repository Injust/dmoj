def check(x, y):
	if x > gx or y > gy:
		score[x, y] = 2000000001
	else:
		print "?", x, y
		__import__("sys").stdout.flush()
		score[x, y] = int(input())


input = __import__("sys").stdin.readline
score = {}
gx, gy, k = map(int, input().split())
x1 = 1
x3 = gx
y1 = 1
y3 = gy
while x1 < x3 or y1 < y3:
	x2 = x1 + x3 >> 1
	y2 = y1 + y3 >> 1
	check(x2, y2)
	check(x2 + 1, y2)
	check(x2, y2 + 1)
	if score[x2, y2] < score[x2 + 1, y2]:
		x3 = x2
	else:
		x1 = x2 + 1
	if score[x2, y2] < score[x2, y2 + 1]:
		y3 = y2
	else:
		y1 = y2 + 1
check(x1, y1)
print "!", score[x1, y1]