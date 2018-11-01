class BIT3D:
	def __init__(self, gx, gy, gz):
		self.data = [[[0] * (gx + 1) for _ in xrange(gy + 1)] for _ in xrange(gz + 1)]
		self.gx = gx
		self.gy = gy
		self.gz = gz

	def add(self, x, y, z, delta):
		while z <= self.gz:
			y1 = y
			while y1 <= self.gy:
				x1 = x
				while x1 <= self.gx:
					self.data[z][y1][x1] += delta
					x1 += -x1 & x1
				y1 += -y1 & y1
			z += -z & z

	def query(self, x, y, z):
		ret = 0
		while z:
			y1 = y
			while y1:
				x1 = x
				while x1:
					ret += self.data[z][y1][x1]
					x1 -= -x1 & x1
				y1 -= -y1 & y1
			z -= -z & z
		return ret

	def sum(self, x1, y1, z1, x2, y2, z2):
		return self.query(x2, y2, z2) - self.query(x2, y2, z1 - 1) - self.query(x1 - 1, y2, z2) + self.query(x1 - 1, y2, z1 - 1) - self.query(x2, y1 - 1, z2) + self.query(x2, y1 - 1, z1 - 1) + self.query(x1 - 1, y1 - 1, z2) - self.query(x1 - 1, y1 - 1, z1 - 1)


n = int(__import__("sys").stdin.readline())
bit = BIT3D(n, n, n)
out = 0
for q in __import__("sys").stdin.read().split("\n")[1:-1]:
	q = q.split()
	if q[0] == "C":
		x, y, z, l = map(int, q[1:])
		bit.add(x, y, z, l - bit.sum(x, y, z, x, y, z))
	elif q[0] == "S":
		q = map(int, q[1:])
		out += bit.sum(*q)
print(out)