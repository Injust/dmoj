#define scan(x)do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
#include <iostream>

char _;

int main() {
	int n;
	int o[10001];
	int c[2][10002];
	std::fill(c[1], c[1] + sizeof(&c[1]), 1);
	int j = 0;
	for (int i = 0; i < 10; i++) {
		scan(n);
		for (; j <= n; j++) {
			c[j & 1][0] = 0;
			for (int k = 0; k <= j; k++) {
				c[j & 1][k + 1] = ((k > 0 ? c[j & 1][k] : 0) + c[j & 1 ^ 1][j - k]) % 1000000007;
			}
			o[j] = c[j & 1][1];
		}
		printf("%d\n", o[n]);
	}
	return 0;
}