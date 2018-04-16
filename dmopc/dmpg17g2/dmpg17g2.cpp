#include <iostream>

int main() {
	char c;
	int a, b, n, q;
	scanf("%d %d", &n, &q);
	int swords[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &swords[i]);
	}
	for (int i = 0; i < q; i++) {
		scanf(" %c %d %d", &c, &a, &b);
		if (c == 'S') {
			swords[a - 1] = b;
		} else if (c == 'Q') {
			long long have = 0;
			long long high = -1000000000;
			for (int j = a - 1; j < b; j++) {
				have += swords[j];
				high = have > high ? have : high;
				have = have < 0 ? 0 : have;
			}
			printf("%lld\n", high);
		}
	}
	return 0;
}