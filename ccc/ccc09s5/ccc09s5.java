import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ccc09s5 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int gy = Integer.parseInt(in.readLine());
		int gx = Integer.parseInt(in.readLine());
		int[][] grid = new int[gy][gx + 1];
		int k = Integer.parseInt(in.readLine());
		int x, y, r, b, d;
		String[] tokens;
		for (int i = 0; i < k; i++) {
			tokens = in.readLine().split(" ");
			x = Integer.parseInt(tokens[0]) - 1;
			y = Integer.parseInt(tokens[1]) - 1;
			r = Integer.parseInt(tokens[2]);
			b = Integer.parseInt(tokens[3]);
			for (int yy = Math.max(0, y - r); yy < Math.min(gy, y + r + 1); yy++) {
				d = (int) Math.sqrt(r * r - (y - yy) * (y - yy));
				grid[yy][Math.max(0, x - d)] += b;
				grid[yy][Math.min(gx, x + d + 1)] -= b;
			}
		}
		int high = 0;
		int out = 0;
		for (y = 0; y < gy; y++) {
			b = 0;
			for (x = 0; x < gx; x++) {
				b += grid[y][x];
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