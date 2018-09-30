def blocked(factors):
	return sum(l / reduce(lambda x, i: x / __import__("fractions").gcd(x, i) * i, c, 1) * (bits & 1 or -1) for bits in xrange(1, len(factors) + 1) for c in __import__("itertools").combinations(factors, bits))


a, b, l = map(int, __import__("sys").stdin.read().split())
factors = [[] for _ in xrange(a + b + 1)]
for i in xrange(1, a + b + 1):
	x = i
	for f in xrange(2, int(i ** 0.5) + 1):
		if not x % f:
			while not x % f:
				x /= f
			factors[i].append(f)
	if x > 1:
		factors[i].append(x)
out = [0, 0, 0]
for i in xrange((a + b >> 1) + 1):
	mul = (i << 1 < a + b) + 1
	notA = blocked(factors[i]) if i else l - 1
	notB = blocked(factors[a + b - i])
	notAB = blocked(list({aa * (aa == bb or bb) for aa in factors[i] for bb in factors[a + b - i]})) if i else notB
	out[0] += mul * notAB
	out[1] += mul * (notA + notB - (notAB << 1))
	out[2] += mul * (l - notA - notB + notAB)
print("\n".join(map(str, out)))