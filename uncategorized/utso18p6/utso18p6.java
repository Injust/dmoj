import java.io.BufferedReader;
import java.io.InputStreamReader;
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

public class utso18p6 {
	public static void main(String[] args) throws Exception {
		FastReader in = new FastReader(new InputStreamReader(System.in));
		int n = in.nextInt();
		int q = in.nextInt();
		int[] val = new int[1 << n];
		for (int i = 0; i < 1 << n; i++) {
			val[i] = in.nextInt();
		}
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if (a < 2) {
				val[b] = c;
			} else if ((b | c) > c) {
				System.out.println(0);
			} else {
				long out = val[b];
				c ^= b;
				int j = c;
				while ((j | b) > b) {
					out += val[j | b];
					j = j - 1 & c;
				}
				System.out.println(out);
			}
		}
		in.close();
	}
}