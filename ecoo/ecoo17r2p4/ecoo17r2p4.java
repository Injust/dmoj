import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

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

public class ecoo17r2p4 {
	public static void main(String[] args) throws Exception {
		FastReader in = new FastReader(new InputStreamReader(System.in));
		int j = 0;
		int[] o = new int[10001];
		int[][] c = new int[2][10002];
		Arrays.fill(c[1], 1);
		for (int i = 0; i < 10; i++) {
			int n = in.nextInt();
			for (; j <= n; j++) {
				c[j & 1][0] = 0;
				for (int k = 0; k <= j; k++) {
					c[j & 1][k + 1] = ((k > 0 ? c[j & 1][k] : 0) + c[j & 1 ^ 1][j - k]) % 1000000007;
				}
				o[j] = c[j & 1][1];
			}
			System.out.println(o[n]);
		}
		in.close();
	}
}