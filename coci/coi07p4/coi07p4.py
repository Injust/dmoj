def dprod(prod, ind):
	if prod > 1000000000 or prod * prod > b:
		return 0
	elif ind > 3:
		return sprod(0, 18, -(-a / prod), b / prod)
	ret = dprod(prod, ind + 1)
	factors[ind] += 1
	ret += dprod(prod * (2, 3, 5, 7)[ind], ind)
	factors[ind] -= 1
	return ret


def sprod(rlow, rwidth, tlow, thigh):
	rhigh = rlow + 10 ** rwidth - 1
	if rlow > thigh or rhigh < tlow:
		return 0
	elif not rwidth:
		return not any(factors)
	within = tlow <= rlow <= rhigh <= thigh
	if within and (rwidth, tuple(factors)) in memo:
		return memo[rwidth, tuple(factors)]
	ret = 0
	for digit in xrange(rlow > 0, 10):
		if all(factors[i] >= df[digit][i] for i in xrange(4)):
			for i in xrange(4):
				factors[i] -= df[digit][i]
			ret += sprod(rlow + digit * 10 ** (rwidth - 1), rwidth - 1, tlow, thigh)
			for i in xrange(4):
				factors[i] += df[digit][i]
	if within:
		memo[rwidth, tuple(factors)] = ret
	return ret


a, b = map(int, __import__("sys").stdin.read().split())
df = (0, 0, 0, 0), (0, 0, 0, 0), (1, 0, 0, 0), (0, 1, 0, 0), (2, 0, 0, 0), (0, 0, 1, 0), (1, 1, 0, 0), (0, 0, 0, 1), (3, 0, 0, 0), (0, 2, 0, 0)
factors = [0, 0, 0, 0]
memo = {}
print(dprod(1, 0))