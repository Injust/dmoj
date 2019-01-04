import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.BitSet;

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

public class dmpg15s5 {
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = in.nextInt();
		int m = in.nextInt();
		BitSet[] grid = new BitSet[n + 1];
		for (int i = 0; i <= n; i++) {
			grid[i] = new BitSet(n + 1);
		}
		for (int i = 0; i < m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int w = in.nextInt();
			int h = in.nextInt();
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
		int ans = 0;
		for (BitSet y : grid) {
			ans += y.cardinality();
		}
		out.println(ans);
		out.close();
	}
}