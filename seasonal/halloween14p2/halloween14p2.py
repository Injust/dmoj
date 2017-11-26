input = __import__("sys").stdin.readline
n, w = map(int, input().split())
cute = [0] * (n + 1)
fat = [0] * (n + 1)
high = [0] * (n + 1)
ind = 0
for _ in xrange(n):
	q = input().split()
	if q[0] == "D":
		ind -= 1
	else:
		ind += 1
		fat[ind] = int(q[1]) + fat[ind - 1]
		cute[ind] = int(q[2]) + cute[ind - 1]
		high[ind] = max(high[ind - 1], cute[ind] - cute[__import__("bisect").bisect_left(fat, fat[ind] - w, hi=ind)])
		print(high[ind])