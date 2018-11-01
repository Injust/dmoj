input = __import__("sys").stdin.readline
l, r, w = map(int, input().split())
ll = sorted(map(int, input().split()), reverse=True)
rr = sorted(map(int, input().split()), reverse=True)
moves = 0
diff = 0
while any(ll) or any(rr):
	a = False
	for i in xrange(l):
		if ll[i] and ll[i] + diff <= w:
			diff += ll[i]
			ll[i] = 0
			a = True
	moves += a
	a = False
	for i in xrange(r):
		if rr[i] and rr[i] - diff <= w:
			diff -= rr[i]
			rr[i] = 0
			a = True
	moves += a
print(moves)