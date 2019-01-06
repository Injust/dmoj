class BIT1D:
	def __init__(self, maxind):
		self.data = [0] * (maxind + 1)
		self.maxind = maxind

	def add(self, ind, delta):
		while ind <= self.maxind:
			self.data[ind] += delta
			ind += -ind & ind

	def query(self, ind):
		ret = 0
		while ind:
			ret += self.data[ind]
			ind -= -ind & ind
		return ret

	sum = lambda self, low, high: self.query(high) - self.query(low - 1)


input = __import__("sys").stdin.readline
n = int(input())
psa = [[0, 0]] + [[val, ind] for ind, val in enumerate(map(int, input().split()), start=1)]
p = int(input())
for i in xrange(1, n + 1):
	psa[i][0] += psa[i - 1][0] - p
bit = BIT1D(n + 1)
out = 0
for pair in sorted(psa):
	out += bit.query(pair[1] + 1)
	bit.add(pair[1] + 1, 1)
print(out)