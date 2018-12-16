#include <algorithm>
#include <iostream>

int main() {
	int n;
	scanf("%d", &n);
	long long a[n][2], d[n], s[n];
	for (int i = 0; i < n; i++) {
		scanf("%lld", &a[i][0]);
		scanf("%lld", &a[i][1]);
		d[i] = a[i][0] - a[i][1];
		s[i] = a[i][0] + a[i][1];
	}
	std::sort(d, d + n);
	std::sort(s, s + n);
	long long out = 0;
	for (int i = 0; i < n; i++) {
		out += std::max(std::abs(a[i][0] - (d[n / 2] + s[n / 2] >> 1)), std::abs(a[i][1] - s[n / 2] + (d[n / 2] + s[n / 2]) / 2));
	}
	printf("%lld\n", out);
	return 0;
}