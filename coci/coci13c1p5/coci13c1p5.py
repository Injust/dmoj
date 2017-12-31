freq = [0] * 2000000
map(lambda size: freq.__setitem__(size - 1, freq[size - 1] + 1), map(int, __import__("sys").stdin.read().split()[1:]))
out = 0
for size in xrange(1, 2000001):
	clubs = 0
	for ind in xrange(size - 1, 2000000, size):
		clubs += freq[ind]
	out = max(out, (clubs > 1) * clubs * size)
print(out)