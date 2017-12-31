import java.io.BufferedReader;
import java.io.InputStreamReader;

class BIT2D {
	private int[][] data;
	private int gx, gy;

	BIT2D(int gx, int gy) {
		data = new int[gy + 1][gx + 1];
		this.gx = gx;
		this.gy = gy;
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

	int query2D(int x1, int y1, int x2, int y2) {
		return query(x2, y2) + query(x1 - 1, y1 - 1) - query(x2, y1 - 1) - query(x1 - 1, y2);
	}

	void update(int x, int y, int delta) {
		for (; y <= gy; y += -y & y) {
			for (int x1 = x; x1 <= gx; x1 += -x1 & x1) {
				data[y][x1] += delta;
			}
		}
	}
}

public class ioi01p1 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = in.readLine().split(" ");
		int s = Integer.parseInt(tokens[1]);
		BIT2D bit = new BIT2D(s, s);
		int i;
		do {
			tokens = in.readLine().split(" ");
			i = Integer.parseInt(tokens[0]);
			if (i == 1) {
				int x = Integer.parseInt(tokens[1]);
				int y = Integer.parseInt(tokens[2]);
				int a = Integer.parseInt(tokens[3]);
				bit.update(x + 1, y + 1, a);
			} else if (i == 2) {
				int l = Integer.parseInt(tokens[1]);
				int b = Integer.parseInt(tokens[2]);
				int r = Integer.parseInt(tokens[3]);
				int t = Integer.parseInt(tokens[4]);
				System.out.println(bit.query2D(l + 1, b + 1, r + 1, t + 1));
			}
		} while (i < 3);
	}
}