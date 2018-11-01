le, gen = map(int, __import__("sys").stdin.readline().split())
cell = map(int, __import__("sys").stdin.read().strip())
while gen:
	cell = [cell[(i + (1 << gen.bit_length() - 1)) % le] ^ cell[(i - (1 << gen.bit_length() - 1)) % le] for i in xrange(le)]
	gen -= (1 << gen.bit_length() - 1)
print("".join(map(str, cell)))