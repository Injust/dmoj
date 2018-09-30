def r(n):
	f[n] = n in f and f[n] or (r(n >> 1) * r((n >> 1) + (n & 1)) + r((n >> 1) - (n & 1 ^ 1)) * r((n >> 1) - 1)) % 1000000007
	return f[n]


f = {0: 1, 1: 1}
print(r(int(__import__("sys").stdin.read()) - 1))