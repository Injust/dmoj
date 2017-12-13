class BIT:
	def __init__(self, length):
		self.data = [0] * (length + 1)
		self.length = length

	def query(self, ind):
		ret = 0
		while ind:
			ret += self.data[ind]
			ind -= -ind & ind
		return ret

	def update(self, ind, delta):
		while ind <= self.length:
			self.data[ind] += delta
			ind += -ind & ind


input = __import__("sys").stdin.readline
n = int(input())
bit = BIT(n)
trees = sorted(enumerate(map(int, input().split()), start=1), key=lambda _: _[1])
out = [0] * int(input())
for pos, line in sorted(enumerate(map(int, input().split()) for _ in xrange(len(out))), key=lambda _: -_[1][2]):
	while trees and trees[-1][1] >= line[2]:
		bit.update(*trees.pop())
	out[pos] = str(bit.query(line[1] + 1) - bit.query(line[0]))
print("\n".join(out))