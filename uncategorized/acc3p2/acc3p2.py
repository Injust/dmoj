print((lambda a: (lambda d, s: (lambda d, s: (lambda d, s: (lambda i, j: sum(max(abs(x - i), abs(y - j)) for x, y in a))(int(d + s) >> 1, int(s - (d + s) / 2)))(*((sum(d[len(d) - 1 >> 1:len(d) + 2 >> 1]) / 2., sum(s[len(s) - 1 >> 1:len(s) + 2 >> 1]) / 2.), (d[len(d) >> 1], s[len(s) >> 1]))[len(a) & 1]))(sorted(d), sorted(s)))(map(lambda _: _[0] - _[1], a), map(lambda _: _[0] + _[1], a)))(map(lambda _: map(int, _.split()), __import__("sys").stdin.read().split("\n")[1:-1])))