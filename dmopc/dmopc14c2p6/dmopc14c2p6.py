def query(ind):
	ret = 0
	while ind:
		ret += bit[ind]
		ind -= -ind & ind
	return ret


def update(ind, delta):
	while ind <= n:
		bit[ind] += delta
		ind += -ind & ind


input = __import__("sys").stdin.readline
n = int(input())
bit = [0] * (n + 1)
trees = sorted(enumerate(map(int, input().split()), start=1), key=lambda _: _[1])
out = [0] * int(input())
for pos, line in sorted(enumerate(map(int, input().split()) for _ in xrange(len(out))), key=lambda _: -_[1][2]):
	while trees and trees[-1][1] >= line[2]:
		ind, m = trees.pop()
		update(ind, m)
	out[pos] = str(query(line[1] + 1) - query(line[0]))
print("\n".join(out))