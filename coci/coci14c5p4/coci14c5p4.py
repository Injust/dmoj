def decrease(arr):
	arr[ind] -= 1
	for i in xrange(ind + 1, len(arr)):
		arr[i] = 9 - (arr[i - 1] & 1)
	return int("".join(map(str, arr)))


def increase(arr):
	arr[ind] += 1
	for i in xrange(ind + 1, len(arr)):
		arr[i] = arr[i - 1] & 1 ^ 1
	return int("".join(map(str, arr)))


n = __import__("sys").stdin.read().strip()
arr = map(int, list(n))
n = int(n)
for ind in xrange(1, len(arr)):
	if arr[ind] & 1 == arr[ind - 1] & 1:
		break
if arr[ind] == 9:
	print(decrease(arr[:]))
elif arr[ind]:
	low = decrease(arr[:])
	high = increase(arr[:])
	if n - low < high - n:
		print(low)
	elif high - n < n - low:
		print(high)
	else:
		print low, high
else:
	print(increase(arr[:]))