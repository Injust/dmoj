input = __import__("sys").stdin.readline
n, b = map(int, input().split())
arr = map(int, input().split())
ind = arr.index(b)
deltaL = [0] * (n << 1)
deltaR = [0] * (n << 1)
delta = 0
for i in xrange(ind, -1, -1):
	if arr[i] < b:
		delta -= 1
	elif arr[i] > b:
		delta += 1
	deltaL[n - delta] += 1
delta = 0
for i in xrange(ind, n):
	if arr[i] < b:
		delta -= 1
	elif arr[i] > b:
		delta += 1
	deltaR[n + delta] += 1
print(sum(deltaL[i] * deltaR[i] for i in xrange(n << 1)))