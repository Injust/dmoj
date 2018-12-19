#define scan(x)do{while((x=getchar())<'0');for(x-='0';'/'<(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
#include <iostream>

char _;
int val[262144];

int main() {
	int n, q, a, b, c;
	scan(n);
	scan(q);
	for (int i = 0; i < 1 << n; i++) {
		scan(val[i]);
	}
	for (int i = 0; i < q; i++) {
		scan(a);
		scan(b);
		scan(c);
		if (a < 2) {
			val[b] = c;
		} else if ((b | c) > c) {
			printf("0\n");
		} else {
			long out = val[b];
			c ^= b;
			int j = c;
			while ((j | b) > b) {
				out += val[j | b];
				j = j - 1 & c;
			}
			printf("%ld\n", out);
		}
	}
	return 0;
}