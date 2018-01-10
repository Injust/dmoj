def factorial(start, value, target):
	for i in range(start + 1, target + 1):
		value = value * i % 4294967291
	return value


cycle = 1
interval = int(__import__("sys").argv[1])
temp = 1
value = 1
for i in range(interval, 4294967291 + interval * 7, interval):
	value = factorial(i - interval, value, i)
	temp = temp << 32 | value
	cycle += 1
	if cycle == 5:
		for shift in range(0, 160, 20):
			__import__("sys").stdout.write(unichr(0x10000 + (temp >> shift & 0x100000 - 1)).encode("utf-8"))
		cycle = 0
		temp = 0