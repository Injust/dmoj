def recurse(left, right):
	if left > right:
		return 1
	if (left, right) not in memo:
		memo[(left, right)] = 0
		for end in xrange(left + 1, right + 1, 2):
			for i in xrange(3):
				if s[left] in {"?", bOpen[i]} and s[end] in {"?", bClose[i]}:
					memo[(left, right)] += recurse(left + 1, end - 1) * recurse(end + 1, right)
	return memo[(left, right)]


s = __import__("sys").stdin.read().strip().split()[1]
bOpen = "([{"
bClose = ")]}"
memo = {}
print(str(recurse(0, len(s) - 1))[-5:])