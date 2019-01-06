import java.io.*;
import java.util.*;

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
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
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
				out.println(0);
			} else {
				long ans = val[b];
				c ^= b;
				int j = c;
				while ((j | b) > b) {
					ans += val[j | b];
					j = j - 1 & c;
				}
				out.println(ans);
			}
		}
		in.close();
		out.close();
	}
}