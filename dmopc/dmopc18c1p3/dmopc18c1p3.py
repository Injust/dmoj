n = int(__import__("sys").stdin.readline())
arr = [0] + map(int, __import__("sys").stdin.read().split())
if arr == sorted(arr):
	print(0)
else:
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
		if add:
			cycles.append(add + [start])
	if len(cycles) > 1:
		link = sum(cycles, [])
		hold = arr[link[-1]]
		for i in xrange(len(link) - 1, 0, -1):
			arr[link[i]] = arr[link[i - 1]]
		arr[link[0]] = hold
		print(2)
		print len(link), " ".join(map(str, link))
		for start in xrange(1, n + 1):
			if start != arr[start]:
				break
		out = [start]
		at = arr[start]
		while at != start:
			out.append(at)
			at = arr[at]
		print(len(out)),
		print(" ".join(map(str, out)))
	else:
		print(1)
		print(len(cycles[0])),
		print(" ".join(map(str, cycles[0])))