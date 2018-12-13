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
n, q = map(int, input().split())
arr = map(int, input().split())
bit = BIT(n)
loc = __import__("collections").defaultdict(list)
for i in xrange(n):
	loc[arr[i]].append(i)
	bit.add(i + 1, arr[i])
out = [0] * q
done = -1
lloc = sorted(loc)
for ind, query in sorted(enumerate(map(int, input().split()) for _ in xrange(q)), key=lambda _: _[1][2]):
	while done + 1 < len(lloc) and lloc[done + 1] < query[2]:
		done += 1
		for j in loc[lloc[done]]:
			bit.add(j + 1, -(arr[j] << 1))
	out[ind] = bit.sum(*query[:2])
print("\n".join(map(str, out)))