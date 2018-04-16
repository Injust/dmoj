input = __import__("sys").stdin.readline
n, q = map(int, input().split())
swords = map(int, input().split())
for _ in xrange(q):
	q = input().split()
	if q[0] == "S":
		swords[int(q[1]) - 1] = int(q[2])
	elif q[0] == "Q":
		have = 0
		high = -1000000000
		for i in xrange(int(q[1]) - 1, int(q[2])):
			have += swords[i]
			high = max(high, have)
			have = max(have, 0)
		print(high)