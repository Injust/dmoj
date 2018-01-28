def recurse(this):
	if argue[this] > 2:
		argue[this] = 0
		party[this] ^= True
		for adj in group[this]:
			if party[this] is party[adj]:
				argue[this] += 1
				argue[adj] += 1
				if argue[adj] > 2:
					recurse(adj)
			else:
				argue[adj] -= 1


input = __import__("sys").stdin.readline
n = int(input())
argue = [0] * n
group = [[] for _ in xrange(n)]
party = [False] * n
for _ in xrange(5):
	line = map(int, input().split())
	for i in xrange(line[0]):
		l = line[(i << 1) + 1] - 1
		r = line[(i << 1) + 2] - 1
		argue[l] += 1
		argue[r] += 1
		group[l].append(r)
		group[r].append(l)
for i in xrange(n):
	recurse(i)
print("".join("B" if party[i] else "A" for i in xrange(n)))