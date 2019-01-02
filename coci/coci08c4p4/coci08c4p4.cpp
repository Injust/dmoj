#include <algorithm>
#include <iostream>

int n;
char grid[512][513];
char out[512][513];

struct data {
	int all0, all1, rec;
};

data recurse(int x1, int x2, int y1, int y2) {
	data ret = {0, 0, 262144};
	if (x2 - x1 == 1) {
		out[y1][x1] = grid[y1][x1];
		ret.all0 = grid[y1][x1] == '1';
		ret.all1 = grid[y1][x1] == '0';
		ret.rec = 0;
	} else {
		int size = x2 - x1 >> 1;
		int xmid = x1 + size;
		int ymid = y1 + size;
		data squares[] = {recurse(x1, xmid, y1, ymid), recurse(xmid, x2, y1, ymid), recurse(x1, xmid, ymid, y2), recurse(xmid, x2, ymid, y2)};
		for (data square : squares) {
			ret.all0 += square.all0;
			ret.all1 += square.all1;
		}
		int best[4];
		int perm[] = {0, 1, 2, 3};
		while (std::next_permutation(perm, perm + 4)) {
			int newcost = squares[perm[0]].all0 + squares[perm[1]].all1 + squares[perm[2]].rec + squares[perm[3]].rec;
			if (newcost < ret.rec) {
				ret.rec = newcost;
				for (int i = 0; i < 4; i++) {
					best[i] = perm[i];
				}
			}
		}
		for (int dy = 0; dy < size; dy++) {
			for (int dx = 0; dx < size; dx++) {
				out[y1 + size * (best[0] >> 1) + dy][x1 + size * (best[0] & 1) + dx] = '0';
				out[y1 + size * (best[1] >> 1) + dy][x1 + size * (best[1] & 1) + dx] = '1';
			}
		}
	}
	return ret;
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%s", grid[i]);
	}
	printf("%d\n", recurse(0, n, 0, n).rec);
	for (int i = 0; i < n; i++) {
		printf("%s\n", out[i]);
	}
	return 0;
}
