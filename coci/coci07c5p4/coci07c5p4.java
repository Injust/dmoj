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

public class coci07c5p4 {
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = in.nextInt();
		int[][] grid = new int[3][n];
		ArrayList<Integer>[] cols = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			cols[i] = new ArrayList<>();
		}
		int[][] rowFreq = new int[3][n];
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < n; x++) {
				grid[y][x] = in.nextInt() - 1;
				cols[grid[y][x]].add(x);
				rowFreq[y][grid[y][x]]++;
			}
		}
		in.close();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		for (int x = 0; x < n; x++) {
			if (rowFreq[1][x] == 0 || rowFreq[2][x] == 0) {
				queue.push(x);
			}
		}
		BitSet deleted = new BitSet(n);
		int ans = 0;
		while (!queue.isEmpty()) {
			int target = queue.pop();
			for (int x : cols[target]) {
				if (!deleted.get(x)) {
					for (int y = 0; y < 3; y++) {
						if (--rowFreq[y][grid[y][x]] == 0) {
							queue.push(grid[y][x]);
						}
					}
					deleted.set(x);
					ans++;
				}
			}
		}
		out.println(ans);
		out.close();
	}
}