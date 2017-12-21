import java.io.BufferedReader;
import java.io.InputStreamReader;

class BIT3D {
	private long[][][] data;
	private int gx, gy, gz;

	BIT3D(int gx, int gy, int gz) {
		data = new long[gz + 1][gy + 1][gx + 1];
		this.gx = gx;
		this.gy = gy;
		this.gz = gz;
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

	long query3D(int x1, int y1, int z1, int x2, int y2, int z2) {
		return query(x2, y2, z2) - query(x2, y2, z1 - 1) - query(x1 - 1, y2, z2) + query(x1 - 1, y2, z1 - 1) - query(x2, y1 - 1, z2) + query(x2, y1 - 1, z1 - 1) + query(x1 - 1, y1 - 1, z2) - query(x1 - 1, y1 - 1, z1 - 1);
	}

	void update(int x, int y, int z, int delta) {
		for (; z <= gz; z += -z & z) {
			for (int y1 = y; y1 <= gy; y1 += -y1 & y1) {
				for (int x1 = x; x1 <= gx; x1 += -x1 & x1) {
					data[z][y1][x1] += delta;
				}
			}
		}
	}
}

public class gfssoc1s4 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		BIT3D bit = new BIT3D(n, n, n);
		int q = Integer.parseInt(in.readLine());
		int x, y, z, l, x1, y1, z1, x2, y2, z2;
		long out = 0;
		String[] tokens;
		for (int i = 0; i < q; i++) {
			tokens = in.readLine().split(" ");
			if (tokens[0].equals("C")) {
				x = Integer.parseInt(tokens[1]);
				y = Integer.parseInt(tokens[2]);
				z = Integer.parseInt(tokens[3]);
				l = Integer.parseInt(tokens[4]);
				bit.update(x, y, z, l - (int) bit.query3D(x, y, z, x, y, z));
			} else if (tokens[0].equals("S")) {
				x1 = Integer.parseInt(tokens[1]);
				y1 = Integer.parseInt(tokens[2]);
				z1 = Integer.parseInt(tokens[3]);
				x2 = Integer.parseInt(tokens[4]);
				y2 = Integer.parseInt(tokens[5]);
				z2 = Integer.parseInt(tokens[6]);
				out += bit.query3D(x1, y1, z1, x2, y2, z2);
			}
		}
		System.out.println(out);
	}
}