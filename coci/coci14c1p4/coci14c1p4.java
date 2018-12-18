import java.io.BufferedReader;
import java.io.InputStreamReader;
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

public class coci14c1p4 {
	private static int[] accuse;
	private static int[] accusations;
	private static BitSet visited;
	private static int out;

	private static void dfs(int accuser, boolean mobster) {
		if (!visited.get(accuser)) {
			visited.flip(accuser);
			if (mobster) {
				out++;
			}
			accusations[accuse[accuser]]--;
			if (mobster || accusations[accuse[accuser]] == 0) {
				dfs(accuse[accuser], !mobster);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		FastReader in = new FastReader(new InputStreamReader(System.in));
		int n = in.nextInt();
		accuse = new int[n];
		accusations = new int[n];
		for (int accuser = 0; accuser < n; accuser++) {
			int accused = in.nextInt() - 1;
			accuse[accuser] = accused;
			accusations[accused]++;
		}
		in.close();
		visited = new BitSet(n);
		for (int accuser = 0; accuser < n; accuser++) {
			if (accusations[accuser] == 0) {
				dfs(accuser, true);
			}
		}
		for (int accuser = 0; accuser < n; accuser++) {
			dfs(accuser, false);
		}
		System.out.println(out);
	}
}