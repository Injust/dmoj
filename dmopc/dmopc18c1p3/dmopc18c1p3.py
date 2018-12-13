n = int(__import__("sys").stdin.readline())
arr = [0] + map(int, __import__("sys").stdin.read().split())
need = set(xrange(1, n + 1))
cycles = []
while need:
	add = []
	start = need.pop()
	at = arr[start]
	while at in need:
		need.remove(at)
		add.append(at)
		at = arr[at]
	add and cycles.append(add + [start])
print((len(cycles) > 0) + (len(cycles) > 1))
if len(cycles) > 1:
	link = sum(cycles, [])
	hold = arr[link[-1]]
	for i in xrange(len(link) - 1, 0, -1):
		arr[link[i]] = arr[link[i - 1]]
	arr[link[0]] = hold
	print len(link), " ".join(map(str, link))
	for start in xrange(1, n + 1):
		if start != arr[start]:
			break
	out = [start]
	at = arr[start]
	while at != start:
		out.append(at)
		at = arr[at]
	print len(out), " ".join(map(str, out))
elif len(cycles):
	print len(cycles[0]), " ".join(map(str, cycles[0]))