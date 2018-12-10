n, k = map(int, __import__("sys").stdin.readline().split())
arr = map(int, __import__("sys").stdin.read().split())
out = 0
r = -1
seen = {}
for l in xrange(n):
	while r + 1 < n and len(seen) < k:
		r += 1
		seen[arr[r]] = (arr[r] in seen and seen[arr[r]]) + 1
	if len(seen) == k:
		out += n - r
	seen[arr[l]] -= 1
	if not seen[arr[l]]:
		del seen[arr[l]]
print(out)