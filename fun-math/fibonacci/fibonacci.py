def r(n):
	if n not in f:
		d = n / 2
		f[n] = (r(d) * r(d + (n & 1)) + r(d - (n & 1 ^ 1)) * r(d - 1)) % 1000000007
	return f[n]


f = {0: 1, 1: 1}
print(r(int(__import__("sys").stdin.read()) - 1))