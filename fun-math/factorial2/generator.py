def factorial(left, right, val):
	for i in xrange(left + 1, right + 1):
		val = val * i % 4294967291
	return val


cycle = 1
interval = int(__import__("sys").argv[1])
out = 1
val = 1
for i in xrange(interval, 4294967291 + interval * 7, interval):
	cycle += 1
	val = factorial(i - interval, i, val)
	out = out << 32 | val
	if cycle == 5:
		__import__("sys").stdout.write("".join(unichr(0x10000 + (out >> shift & 0x100000 - 1)) for shift in xrange(0, 160, 20)).encode("utf-8"))
		cycle = 0
		out = 0