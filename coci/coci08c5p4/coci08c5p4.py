input = __import__("sys").stdin.readline
n, h = map(int, input().split())
friends = [(lambda a: tuple(i for i in xrange(n) if a[i] == "1"))(input()) for _ in xrange(n)]
total = 0
state = 1
lookup = {}
c = h
while c:
	temp = state
	state = 0
	for orig in xrange(n):
		if temp & 1 << orig:
			for dest in friends[orig]:
				state ^= 1 << dest
				total += 1
		elif c < h:
			total += len(friends[orig]) << 1
	c -= 1
	if state in lookup:
		total += c / (lookup[state][0] - c) * (total - lookup[state][1])
		c %= lookup[state][0] - c
	else:
		lookup[state] = c, total
print(total)