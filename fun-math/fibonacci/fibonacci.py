f = {0: 1, 1: 1}
n = int(__import__("sys").stdin.read()) - 1
r = lambda n: f.__setitem__(n, n in f and f[n] or ((r(n >> 1) or f[n >> 1]) * (r((n >> 1) + (n & 1)) or f[(n >> 1) + (n & 1)]) + (r((n >> 1) - (n & 1 ^ 1)) or f[(n >> 1) - (n & 1 ^ 1)]) * (r((n >> 1) - 1) or f[(n >> 1) - 1])) % 1000000007)
r(n)
print(f[n])