#include <iostream>

char grid[2000][2001];
int gx, gy;

void dfs(int x, int y) {
	if (grid[y][x] < 70) {
		for (int xx = x + 1; xx < gx; xx++) {
			if (grid[y][xx] > 46) {
				dfs(xx, y);
			}
		}
	} else if (grid[y][x] < 79) {
		for (int yy = y - 1; yy >= 0; yy--) {
			if (grid[yy][x] > 46) {
				dfs(x, yy);
			}
		}
	} else if (grid[y][x] < 84) {
		for (int yy = y + 1; yy < gy; yy++) {
			if (grid[yy][x] > 46) {
				dfs(x, yy);
			}
		}
	} else if (grid[y][x] < 88) {
		for (int xx = x - 1; xx >= 0; xx--) {
			if (grid[y][xx] > 46) {
				dfs(xx, y);
			}
		}
	}
	grid[y][x] = 46;
	printf("(%d,%d)\n", y, x);
}

int main() {
	scanf("%d %d", &gy, &gx);
	for (int y = 0; y < gy; y++) {
		scanf("%s", grid[y]);
	}
	for (int y = 0; y < gy; y++) {
		for (int x = 0; x < gx; x++) {
			if (grid[y][x] > 46) {
				dfs(x, y);
			}
		}
	}
	return 0;
}