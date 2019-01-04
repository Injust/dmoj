import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;

class BIT3D {
	private long[][][] data;
	private int gx, gy, gz;

	BIT3D(int gx, int gy, int gz) {
		data = new long[gz + 1][gy + 1][gx + 1];
		this.gx = gx;
		this.gy = gy;
		this.gz = gz;
	}

	void add(int x, int y, int z, int delta) {
		for (; z <= gz; z += -z & z) {
			for (int y1 = y; y1 <= gy; y1 += -y1 & y1) {
				for (int x1 = x; x1 <= gx; x1 += -x1 & x1) {
					data[z][y1][x1] += delta;
				}
			}
		}
	}

	private long query(int x, int y, int z) {
		long ret = 0;
		for (; z > 0; z -= -z & z) {
			for (int y1 = y; y1 > 0; y1 -= -y1 & y1) {
				for (int x1 = x; x1 > 0; x1 -= -x1 & x1) {
					ret += data[z][y1][x1];
				}
			}
		}
		return ret;
	}

	long sum(int x1, int y1, int z1, int x2, int y2, int z2) {
		return query(x2, y2, z2) - query(x2, y2, z1 - 1) - query(x1 - 1, y2, z2) + query(x1 - 1, y2, z1 - 1) - query(x2, y1 - 1, z2) + query(x2, y1 - 1, z1 - 1) + query(x1 - 1, y1 - 1, z2) - query(x1 - 1, y1 - 1, z1 - 1);
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

public class gfssoc1s4 {
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int n = in.nextInt();
		int q = in.nextInt();
		BIT3D bit = new BIT3D(n, n, n);
		long ans = 0;
		for (int i = 0; i < q; i++) {
			char c = in.nextChar();
			if (c == 67) {
				int x = in.nextInt();
				int y = in.nextInt();
				int z = in.nextInt();
				int l = in.nextInt();
				bit.add(x, y, z, l - (int) bit.sum(x, y, z, x, y, z));
			} else if (c == 83) {
				int x1 = in.nextInt();
				int y1 = in.nextInt();
				int z1 = in.nextInt();
				int x2 = in.nextInt();
				int y2 = in.nextInt();
				int z2 = in.nextInt();
				ans += bit.sum(x1, y1, z1, x2, y2, z2);
			}
		}
		in.close();
		out.println(ans);
		out.close();
	}
}