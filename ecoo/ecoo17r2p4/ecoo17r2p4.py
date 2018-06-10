i = 0
o = [0] * 10001
c = [[0] * 10002, [1] * 10002]
for n in map(int, __import__("sys").stdin.read().split()):
	for i in xrange(i, n + 1):
		c[i & 1][0] = 0
		for j in xrange(i + 1):
			c[i & 1][j + 1] = ((c[i & 1][j] if j else 0) + c[i & 1 ^ 1][i - j]) % 1000000007
		o[i] = c[i & 1][1]
	print(o[n])