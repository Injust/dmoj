import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ccc09s5 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int gy = Integer.parseInt(in.readLine());
		int gx = Integer.parseInt(in.readLine());
		int[][] grid = new int[gy][gx + 1];
		int k = Integer.parseInt(in.readLine());
		for (int i = 0; i < k; i++) {
			String[] tokens = in.readLine().split(" ");
			int x = Integer.parseInt(tokens[0]) - 1;
			int y = Integer.parseInt(tokens[1]) - 1;
			int r = Integer.parseInt(tokens[2]);
			int b = Integer.parseInt(tokens[3]);
			for (int yy = Math.max(0, y - r); yy < Math.min(gy, y + r + 1); yy++) {
				int d = (int) Math.sqrt(r * r - (y - yy) * (y - yy));
				grid[yy][Math.max(0, x - d)] += b;
				grid[yy][Math.min(gx, x + d + 1)] -= b;
			}
		}
		in.close();
		int high = 0;
		int out = 0;
		for (int[] y : grid) {
			int b = 0;
			for (int x : y) {
				b += x;
				if (b > high) {
					out = 1;
					high = b;
				} else if (b == high) {
					out++;
				}
			}
		}
		System.out.println(high);
		System.out.println(out);
	}
}