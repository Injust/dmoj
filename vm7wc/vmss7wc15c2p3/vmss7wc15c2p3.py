num = []
stack = []
out = 0
for h in map(int, __import__("sys").stdin.read().split()[1:]):
	while stack and stack[-1] < h:
		out += num.pop()
		stack.pop()
	if stack and stack[-1] == h:
		out += num[-1] + (len(num) > 1)
		num[-1] += 1
	else:
		out += bool(stack)
		num.append(1)
		stack.append(h)
print(out)