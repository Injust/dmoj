class BIT:
	def __init__(self, length):
		self.data = [0] * (length + 1)
		self.length = length

	def add(self, ind, delta):
		while ind <= self.length:
			self.data[ind] += delta
			ind += -ind & ind

	def query(self, ind):
		ret = 0
		while ind:
			ret += self.data[ind]
			ind -= -ind & ind
		return ret

	def sum(self, low, high):
		return self.query(high) - self.query(low - 1)


input = __import__("sys").stdin.readline
n, q = map(int, input().split())
bit = BIT(n)
peaks = []
done = n
out = [0] * q
arr = map(int, input().split())
for pos, query in sorted(enumerate(map(int, input().split()) for _ in xrange(q)), key=lambda _: -_[1][0]):
	while done > query[0] - 1:
		done -= 1
		while peaks and arr[done] >= arr[peaks[-1]]:
			bit.add(peaks.pop() + 1, -1)
		peaks.append(done)
		bit.add(done + 1, 1)
	out[pos] = str(bit.query(query[1]))
print("\n".join(out))