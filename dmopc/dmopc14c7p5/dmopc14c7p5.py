input = __import__("sys").stdin.readline
n, m = map(int, input().split())
a, b, c = map(int, input().split())
s = sorted(map(int, input().split()))
aurora = [0]
paramail = [0]
for i in xrange(n):
	aurora.append(aurora[-1] + (s[-1 - i] - 1) * a + c * i)
	paramail.append(paramail[-1] + (s[i] - 1) * b)
print(min(aurora[i] + paramail[-1 - i] for i in xrange(n + 1)))