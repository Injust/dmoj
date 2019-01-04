import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class BIT1D {
	private int[] data;
	private int maxind;

	BIT1D(int maxind) {
		data = new int[maxind + 1];
		this.maxind = maxind;
	}

	void add(int ind, int delta) {
		for (; ind <= maxind; ind += -ind & ind) {
			data[ind] += delta;
		}
	}

	int query(int ind) {
		int ret = 0;
		for (; ind > 0; ind -= -ind & ind) {
			ret += data[ind];
		}
		return ret;
	}

	int sum(int low, int high) {
		return query(high) - query(low - 1);
	}
}

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

public class coci15c2p5 {
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = in.nextInt();
		StringTokenizer st = new StringTokenizer(in.readLine());
		int p = in.nextInt();
		in.close();
		long[][] psa = new long[n + 1][2];
		for (int i = 1; i <= n; i++) {
			psa[i][0] = Integer.parseInt(st.nextToken()) + psa[i - 1][0] - p;
			psa[i][1] = i;
		}
		Arrays.sort(psa, Comparator.<long[]>comparingLong(a -> a[0]).thenComparingLong(a -> a[1]));
		BIT1D bit = new BIT1D(n + 1);
		long ans = 0;
		for (long[] pair : psa) {
			ans += bit.query((int) pair[1] + 1);
			bit.add((int) pair[1] + 1, 1);
		}
		out.println(ans);
		out.close();
	}
}