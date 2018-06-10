freq = [0] * 2000000
map(lambda size: freq.__setitem__(size - 1, freq[size - 1] + 1), map(int, __import__("sys").stdin.read().split()[1:]))
print(max((lambda clubs: (clubs > 1) * clubs * size)(sum(freq[ind] for ind in xrange(size - 1, 2000000, size))) for size in xrange(1, 2000001)))