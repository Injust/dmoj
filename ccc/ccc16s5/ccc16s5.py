d, cell = map(int, __import__("sys").stdin.readline().split()), map(int, __import__("sys").stdin.readline().strip())
while d[1]:
	cell, d[1] = [cell[(i + (1 << d[1].bit_length() - 1)) % d[0]] ^ cell[(i - (1 << d[1].bit_length() - 1)) % d[0]] for i in xrange(d[0])], d[1] - (1 << d[1].bit_length() - 1)
print("".join(map(str, cell)))