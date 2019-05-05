input = __import__("sys").stdin.readline
n, v = map(int, input().split())
coins = map(int, input().split())
x = -1
dp = [0] + [-1] * 10000
out = [0] * v
for c, l, ind in sorted((map(int, input().split()) + [_] for _ in xrange(v)), key=lambda _: _[1]):
	for x in xrange(x + 1, l):
		for i in xrange(coins[x], 10001):
			dp[i] = (~dp[i] and min(dp[i], dp[i - coins[x]] + 1) or dp[i - coins[x]] + 1, dp[i])[dp[i - coins[x]] < 0]
	out[ind] = dp[c]
print("\n".join(map(str, out)))