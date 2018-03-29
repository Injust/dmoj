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
n = int(input())
psa = [0] + map(int, input().split())
p = int(input())
lookup = [(0, 0)]
for i in xrange(1, n + 1):
	psa[i] += psa[i - 1] - p
	lookup.append((psa[i], i))
lookup.sort()
bit = BIT(n + 1)
left = 0
out = 0
for right in xrange(n + 1):
	while left < right and lookup[right][0] >= lookup[left][0]:
		bit.add(lookup[left][1] + 1, 1)
		left += 1
	out += bit.query(lookup[right][1] + 1)
print(out)