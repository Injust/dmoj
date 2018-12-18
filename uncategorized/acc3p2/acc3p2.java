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

public class acc3p2 {
	public static void main(String[] args) throws Exception {
		FastReader in = new FastReader(new InputStreamReader(System.in));
		int n = in.nextInt();
		long[][] a = new long[n][2];
		long[] d = new long[n];
		long[] s = new long[n];
		for (int i = 0; i < n; i++) {
			a[i][0] = in.nextLong();
			a[i][1] = in.nextLong();
			d[i] = a[i][0] - a[i][1];
			s[i] = a[i][0] + a[i][1];
		}
		in.close();
		Arrays.sort(d);
		Arrays.sort(s);
		long out = 0;
		for (int i = 0; i < n; i++) {
			out += Math.max(Math.abs(a[i][0] - (d[n / 2] + s[n / 2] >> 1)), Math.abs(a[i][1] - s[n / 2] + (d[n / 2] + s[n / 2]) / 2));
		}
		System.out.println(out);
	}
}