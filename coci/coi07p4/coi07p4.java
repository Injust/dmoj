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

public class coi07p4 {
	private static FastReader in;
	private static PrintWriter out;
	private static final int[][] df = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}, {0, 1, 0, 0}, {2, 0, 0, 0}, {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 1}, {3, 0, 0, 0}, {0, 2, 0, 0}};
	private static long a, b;
	private static int[] factors;
	private static int[][][][][] memo;

	private static long dprod(long prod, int ind) {
		if (prod > 1000000000 || prod * prod > b) {
			return 0;
		} else if (ind > 3) {
			return sprod(0, 0, 1000000000000000000L, (a + prod - 1) / prod, b / prod);
		}
		long ret = dprod(prod, ind + 1);
		factors[ind]++;
		ret += dprod(prod * new int[]{2, 3, 5, 7}[ind], ind);
		factors[ind]--;
		return ret;
	}

	private static int sprod(int n, long rlow, long rwidth, long tlow, long thigh) {
		long rhigh = rlow + rwidth - 1;
		if (rlow > thigh || rhigh < tlow) {
			return 0;
		} else if (n > 17) {
			for (int i = 0; i < 4; i++) {
				if (factors[i] > 0) {
					return 0;
				}
			}
			return 1;
		}
		boolean within = tlow <= rlow && rhigh <= thigh;
		if (within && memo[n][factors[0]][factors[1]][factors[2]][factors[3]] > 0) {
			return memo[n][factors[0]][factors[1]][factors[2]][factors[3]] - 1;
		}
		int ret = 0;
		rwidth /= 10;
		for (int digit = rlow > 0 ? 1 : 0; digit <= 9; digit++) {
			boolean cont = true;
			for (int i = 0; i < 4; i++) {
				cont &= factors[i] >= df[digit][i];
			}
			if (cont) {
				for (int i = 0; i < 4; i++) {
					factors[i] -= df[digit][i];
				}
				ret += sprod(n + 1, rlow + digit * rwidth, rwidth, tlow, thigh);
				for (int i = 0; i < 4; i++) {
					factors[i] += df[digit][i];
				}
			}
		}
		if (within) {
			memo[n][factors[0]][factors[1]][factors[2]][factors[3]] = ret + 1;
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		a = in.nextLong();
		b = in.nextLong();
		in.close();
		factors = new int[4];
		memo = new int[18][30][19][13][11];
		out.println(dprod(1, 0));
		out.close();
	}
}