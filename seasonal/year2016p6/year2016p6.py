input = __import__("sys").stdin.readline
l, r, w = map(int, input().split())
ll = sorted(map(int, input().split()), reverse=True)
rr = sorted(map(int, input().split()), reverse=True)
moves = 0
temp = 0
while sum(ll) or sum(rr):
	a = False
	for i in range(l):
		if ll[i] and ll[i] + temp <= w:
			temp += ll[i]
			ll[i] = 0
			a = True
	moves += a
	temp *= -1
	a = False
	for j in range(r):
		if rr[j] and rr[j] + temp <= w:
			temp += rr[j]
			rr[j] = 0
			a = True
	moves += a
	temp *= -1
print(moves)