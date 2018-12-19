input = __import__("sys").stdin.readline
n, q = map(int, input().split())
val = map(int, input().split())
for _ in xrange(q):
	a, b, c = map(int, input().split())
	if a < 2:
		val[b] = c
	elif b | c > c:
		print(0)
	else:
		out = val[b]
		c ^= b
		i = c
		while i | b > b:
			out += val[i | b]
			i = i - 1 & c
		print(out)