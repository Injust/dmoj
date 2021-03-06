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

public class cco15p4 {
	private static FastReader in;
	private static PrintWriter out;
	private static char[][] grid;
	private static int gx, gy;

	private static void dfs(int x, int y) {
		if (grid[y][x] < 70) {
			for (int xx = x + 1; xx < gx; xx++) {
				if (grid[y][xx] > 46) {
					dfs(xx, y);
				}
			}
		} else if (grid[y][x] < 79) {
			for (int yy = y - 1; yy >= 0; yy--) {
				if (grid[yy][x] > 46) {
					dfs(x, yy);
				}
			}
		} else if (grid[y][x] < 84) {
			for (int yy = y + 1; yy < gy; yy++) {
				if (grid[yy][x] > 46) {
					dfs(x, yy);
				}
			}
		} else if (grid[y][x] < 88) {
			for (int xx = x - 1; xx >= 0; xx--) {
				if (grid[y][xx] > 46) {
					dfs(xx, y);
				}
			}
		}
		grid[y][x] = 46;
		out.println("(" + y + "," + x + ")");
	}

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		gy = in.nextInt();
		gx = in.nextInt();
		grid = new char[gy][gx];
		for (int y = 0; y < gy; y++) {
			grid[y] = in.readLine().toCharArray();
		}
		in.close();
		for (int y = 0; y < gy; y++) {
			for (int x = 0; x < gx; x++) {
				if (grid[y][x] > 46) {
					dfs(x, y);
				}
			}
		}
		out.close();
	}
}