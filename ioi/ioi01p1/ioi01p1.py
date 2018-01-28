class BIT2D:
	def __init__(self, gx, gy):
		self.data = [[0] * (gx + 1) for _ in xrange(gy + 1)]
		self.gx = gx
		self.gy = gy

	def add(self, x, y, delta):
		while y <= self.gy:
			x1 = x
			while x1 <= self.gx:
				self.data[y][x1] += delta
				x1 += -x1 & x1
			y += -y & y

	def query(self, x, y):
		ret = 0
		while y:
			x1 = x
			while x1:
				ret += self.data[y][x1]
				x1 -= -x1 & x1
			y -= -y & y
		return ret

	def sum(self, x1, y1, x2, y2):
		return self.query(x2, y2) + self.query(x1 - 1, y1 - 1) - self.query(x2, y1 - 1) - self.query(x1 - 1, y2)


input = __import__("sys").stdin.readline
s = int(input().split()[1])
bit = BIT2D(s, s)
data = map(int, input().split())
while data[0] < 3:
	if data[0] == 1:
		x, y, a = data[1:]
		bit.add(x + 1, y + 1, a)
	elif data[0] == 2:
		l, b, r, t = data[1:]
		print(bit.sum(l + 1, b + 1, r + 1, t + 1))
	data = map(int, input().split())