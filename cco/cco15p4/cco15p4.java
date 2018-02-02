import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cco15p4 {
	private static char[][] grid;
	private static int gx, gy;

	private static void dfs(int x, int y) {
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
		System.out.println("(" + y + "," + x + ")");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = in.readLine().split(" ");
		gy = Integer.parseInt(tokens[0]);
		gx = Integer.parseInt(tokens[1]);
		grid = new char[gy][gx];
		for (int y = 0; y < gy; y++) {
			grid[y] = in.readLine().toCharArray();
		}
		in.close();
		for (int y = 0; y < gy; y++) {
			for (int x = 0; x < gx; x++) {
				if (grid[y][x] != '.') {
					dfs(x, y);
				}
			}
		}
	}
}