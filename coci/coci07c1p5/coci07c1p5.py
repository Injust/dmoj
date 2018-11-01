n, b = map(int, __import__("sys").stdin.readline().split())
arr = map(int, __import__("sys").stdin.read().split())
ind = arr.index(b)
deltaL = [0] * (n << 1)
deltaR = [0] * (n << 1)
delta = 0
for i in xrange(ind, -1, -1):
	delta -= arr[i] < b
	delta += arr[i] > b
	deltaL[n - delta] += 1
delta = 0
for i in xrange(ind, n):
	delta -= arr[i] < b
	delta += arr[i] > b
	deltaR[n + delta] += 1
print(sum(deltaL[i] * deltaR[i] for i in xrange(n << 1)))