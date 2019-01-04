import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;

class BIT2D {
	private int[][] data;
	private int gx, gy;

	BIT2D(int gx, int gy) {
		data = new int[gy + 1][gx + 1];
		this.gx = gx;
		this.gy = gy;
	}

	void add(int x, int y, int delta) {
		for (; y <= gy; y += -y & y) {
			for (int x1 = x; x1 <= gx; x1 += -x1 & x1) {
				data[y][x1] += delta;
			}
		}
	}

	private int query(int x, int y) {
		int ret = 0;
		for (; y > 0; y -= -y & y) {
			for (int x1 = x; x1 > 0; x1 -= -x1 & x1) {
				ret += data[y][x1];
			}
		}
		return ret;
	}

	int sum(int x1, int y1, int x2, int y2) {
		return query(x2, y2) + query(x1 - 1, y1 - 1) - query(x2, y1 - 1) - query(x1 - 1, y2);
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

public class ioi01p1 {
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		in.nextInt();
		int s = in.nextInt();
		BIT2D bit = new BIT2D(s, s);
		int i;
		do {
			i = in.nextInt();
			if (i == 1) {
				int x = in.nextInt();
				int y = in.nextInt();
				int a = in.nextInt();
				bit.add(x + 1, y + 1, a);
			} else if (i == 2) {
				int l = in.nextInt();
				int b = in.nextInt();
				int r = in.nextInt();
				int t = in.nextInt();
				out.println(bit.sum(l + 1, b + 1, r + 1, t + 1));
			}
		} while (i < 3);
		in.close();
		out.close();
	}
}