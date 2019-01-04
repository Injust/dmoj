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

public class coci08c3p5 {
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = in.nextInt();
		int[] arr = new int[n];
		int[][] ll = new int[2][n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
			ll[0][i + 1] = i;
			ll[1][i] = i + 1;
		}
		in.close();
		ll[1][0] = 0;
		int[][] adj = new int[n][2];
		for (int i = n - 1; i >= 0; i--) {
			adj[arr[i] - 1][0] = ll[0][arr[i]];
			adj[arr[i] - 1][1] = ll[1][arr[i]];
			ll[1][ll[0][arr[i]]] = ll[1][arr[i]];
			ll[0][ll[1][arr[i]]] = ll[0][arr[i]];
		}
		int[] depth = new int[n + 1];
		depth[0] = -1;
		long ans = 0;
		for (int i : arr) {
			depth[i] = Math.max(depth[adj[i - 1][0]], depth[adj[i - 1][1]]) + 1;
			out.println(ans += depth[i]);
		}
		out.close();
	}
}