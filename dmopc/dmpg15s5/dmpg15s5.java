import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class dmpg15s5 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = in.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		BitSet[] grid = new BitSet[n + 1];
		for (int i = 0; i <= n; i++) {
			grid[i] = new BitSet(n + 1);
		}
		for (int i = 0; i < m; i++) {
			tokens = in.readLine().split(" ");
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);
			int w = Integer.parseInt(tokens[2]);
			int h = Integer.parseInt(tokens[3]);
			grid[y].flip(x);
			grid[y].flip(x + w);
			grid[y + h].flip(x);
			grid[y + h].flip(x + w);
		}
		in.close();
		for (BitSet y : grid) {
			for (int x = 1; x <= n; x++) {
				y.set(x, y.get(x) ^ y.get(x - 1));
			}
		}
		for (int y = 1; y <= n; y++) {
			grid[y].xor(grid[y - 1]);
		}
		int out = 0;
		for (BitSet y : grid) {
			out += y.cardinality();
		}
		System.out.println(out);
	}
}