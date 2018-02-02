#include <iostream>

char grid[2000][2001];
int gx, gy;

void dfs(int x, int y) {
	if (grid[y][x] == 'N') {
		for (int yy = y - 1; yy >= 0; yy--) {
			if (grid[yy][x] != '.') {
				dfs(x, yy);
			}
		}
	} else if (grid[y][x] == 'S') {
		for (int yy = y + 1; yy < gy; yy++) {
			if (grid[yy][x] != '.') {
				dfs(x, yy);
			}
		}
	} else if (grid[y][x] == 'E') {
		for (int xx = x + 1; xx < gx; xx++) {
			if (grid[y][xx] != '.') {
				dfs(xx, y);
			}
		}
	} else if (grid[y][x] == 'W') {
		for (int xx = x - 1; xx >= 0; xx--) {
			if (grid[y][xx] != '.') {
				dfs(xx, y);
			}
		}
	}
	grid[y][x] = '.';
	printf("(%d,%d)\n", y, x);
}

int main() {
	scanf("%d %d", &gy, &gx);
	for (int y = 0; y < gy; y++) {
		scanf("%s", grid[y]);
	}
	for (int y = 0; y < gy; y++) {
		for (int x = 0; x < gx; x++) {
			if (grid[y][x] != '.') {
				dfs(x, y);
			}
		}
	}
	return 0;
}