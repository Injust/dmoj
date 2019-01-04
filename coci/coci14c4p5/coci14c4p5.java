import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
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

public class coci14c4p5 {
	private static FastReader in;
	private static PrintWriter out;
	private static int[] argue;
	private static ArrayList<Integer>[] group;
	private static BitSet party;

	private static void recurse(int at) {
		if (argue[at] > 2) {
			argue[at] = 0;
			party.flip(at);
			for (int adj : group[at]) {
				if (party.get(at) == party.get(adj)) {
					argue[at]++;
					argue[adj]++;
					if (argue[adj] > 2) {
						recurse(adj);
					}
				} else {
					argue[adj]--;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = in.nextInt();
		argue = new int[n];
		group = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			group[i] = new ArrayList<>();
		}
		party = new BitSet(n);
		for (int i = 0; i < 5; i++) {
			int m = in.nextInt();
			for (int j = 1; j <= m; j++) {
				int l = in.nextInt() - 1;
				int r = in.nextInt() - 1;
				argue[l]++;
				argue[r]++;
				group[l].add(r);
				group[r].add(l);
			}
		}
		in.close();
		for (int i = 0; i < n; i++) {
			recurse(i);
		}
		for (int i = 0; i < n; i++) {
			out.print(party.get(i) ? 'A' : 'B');
		}
		out.close();
	}
}