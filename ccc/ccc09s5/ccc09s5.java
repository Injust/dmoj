import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;

class FastReader extends BufferedReader {
	FastReader(Reader in) {
		super(in);
	}

	char nextChar() throws Exception {
		int c;
		while ((c = read()) < 33);
		return (char) c;
	}

	double nextDouble() throws Exception {
		int c;
		double div = 1;
		double ret = 0;
		while ((c = read()) < 33);
		boolean neg = c == 45;
		if (neg) {
			c = read();
		}
		do {
			ret = ret * 10 + c - 48;
		} while ((c = read()) > 47 && c < 58);
		if (c == 46) {
			while ((c = read()) > 47 && c < 58) {
				ret += (c - 48) / (div *= 10);
			}
		}
		return neg ? -ret : ret;
	}

	int nextInt() throws Exception {
		int c;
		int ret = 0;
		while ((c = read()) < 33);
		boolean neg = c == 45;
		if (neg) {
			c = read();
		}
		do {
			ret = ret * 10 + c - 48;
		} while ((c = read()) > 47 && c < 58);
		return neg ? -ret : ret;
	}

	long nextLong() throws Exception {
		int c;
		long ret = 0;
		while ((c = read()) < 33);
		boolean neg = c == 45;
		if (neg) {
			c = read();
		}
		do {
			ret = ret * 10 + c - 48;
		} while ((c = read()) > 47 && c < 58);
		return neg ? -ret : ret;
	}
}

public class ccc09s5 {
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int gy = in.nextInt();
		int gx = in.nextInt();
		int[][] grid = new int[gy][gx + 1];
		int k = in.nextInt();
		for (int i = 0; i < k; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			int r = in.nextInt();
			int b = in.nextInt();
			for (int yy = Math.max(0, y - r); yy < Math.min(gy, y + r + 1); yy++) {
				int d = (int) Math.sqrt(r * r - (y - yy) * (y - yy));
				grid[yy][Math.max(0, x - d)] += b;
				grid[yy][Math.min(gx, x + d + 1)] -= b;
			}
		}
		in.close();
		int high = 0;
		int ans = 0;
		for (int[] y : grid) {
			int b = 0;
			for (int x : y) {
				b += x;
				if (b > high) {
					ans = 1;
					high = b;
				} else if (b == high) {
					ans++;
				}
			}
		}
		out.println(high);
		out.println(ans);
		out.close();
	}
}