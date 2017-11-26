import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = in.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		boolean[][] grid = new boolean[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			tokens = in.readLine().split(" ");
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);
			int w = Integer.parseInt(tokens[2]);
			int h = Integer.parseInt(tokens[3]);
			grid[x][y] ^= true;
			grid[x + w][y] ^= true;
			grid[x][y + h] ^= true;
			grid[x + w][y + h] ^= true;
		}
		for (int x = 0; x <= n; x++) {
			for (int y = 1; y <= n; y++) {
				grid[x][y] ^= grid[x][y - 1];
			}
		}
		for (int x = 1; x <= n; x++) {
			for (int y = 0; y <= n; y++) {
				grid[x][y] ^= grid[x - 1][y];
			}
		}
		int out = 0;
		for (int x = 0; x <= n; x++) {
			for (int y = 0; y <= n; y++) {
				if (grid[x][y]) {
					out++;
				}
			}
		}
		System.out.println(out);
	}
}