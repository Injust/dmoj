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


arr = dict(map(reversed, enumerate(map(int, __import__("sys").stdin.read().split()[1:]), start=1)))
state = BIT1D(len(arr))
for i in xrange(len(arr)):
	state.add(i + 1, 1)
for i in xrange(len(arr) >> 1):
	print(state.sum(1, arr[i + 1] - 1))
	state.add(arr[i + 1], -1)
	print(state.sum(arr[len(arr) - i] + 1, len(arr)))
	state.add(arr[len(arr) - i], -1)
if len(arr) & 1:
	print(0)