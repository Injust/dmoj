class BIT:
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

	def sum(self, low, high):
		return self.query(high) - self.query(low - 1)


input = __import__("sys").stdin.readline
n = int(input())
bit = BIT(n)
trees = sorted(enumerate(map(int, input().split()), start=1), key=lambda _: _[1])
out = [0] * int(input())
for pos, line in sorted(enumerate(map(int, input().split()) for _ in xrange(len(out))), key=lambda _: -_[1][2]):
	while trees and trees[-1][1] >= line[2]:
		bit.add(*trees.pop())
	out[pos] = `bit.sum(line[0] + 1, line[1] + 1)`
print("\n".join(out))