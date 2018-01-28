n, k, arr = (lambda arr: (arr[0], arr[1], arr[2:]))(map(int, __import__("sys").stdin.read().split()))
low = 0
high = 1000000
psa = [0] * (n + 1)
while high - low > 0.001:
	mid = float(high + low) / 2
	for i in xrange(1, n + 1):
		psa[i] = psa[i - 1] + arr[i - 1] - mid
	lowest = 0
	for i in xrange(k, n + 1):
		if psa[i] > lowest:
			low = mid
			break
		lowest = min(lowest, psa[i - k + 1])
	else:
		high = mid
print(low)