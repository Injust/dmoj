import java.io.BufferedReader;
import java.io.InputStreamReader;

public class coi07p4 {
	private static final int[][] df = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}, {0, 1, 0, 0}, {2, 0, 0, 0}, {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 1}, {3, 0, 0, 0}, {0, 2, 0, 0}};
	private static long a, b;
	private static int[] factors;
	private static int[][][][][] memo;

	private static long dprod(long prod, int ind) {
		if (prod > 1000000000 || prod * prod > b) {
			return 0;
		} else if (ind > 3) {
			return sprod(0, 0, 1000000000000000000L, (a + prod - 1) / prod, b / prod);
		}
		long ret = dprod(prod, ind + 1);
		factors[ind]++;
		ret += dprod(prod * new int[]{2, 3, 5, 7}[ind], ind);
		factors[ind]--;
		return ret;
	}

	private static int sprod(int n, long rlow, long rwidth, long tlow, long thigh) {
		long rhigh = rlow + rwidth - 1;
		if (rlow > thigh || rhigh < tlow) {
			return 0;
		} else if (n > 17) {
			for (int i = 0; i < 4; i++) {
				if (factors[i] > 0) {
					return 0;
				}
			}
			return 1;
		}
		boolean within = tlow <= rlow && rhigh <= thigh;
		if (within && memo[n][factors[0]][factors[1]][factors[2]][factors[3]] > 0) {
			return memo[n][factors[0]][factors[1]][factors[2]][factors[3]] - 1;
		}
		int ret = 0;
		rwidth /= 10;
		for (int digit = rlow > 0 ? 1 : 0; digit <= 9; digit++) {
			boolean cont = true;
			for (int i = 0; i < 4; i++) {
				cont &= factors[i] >= df[digit][i];
			}
			if (cont) {
				for (int i = 0; i < 4; i++) {
					factors[i] -= df[digit][i];
				}
				ret += sprod(n + 1, rlow + digit * rwidth, rwidth, tlow, thigh);
				for (int i = 0; i < 4; i++) {
					factors[i] += df[digit][i];
				}
			}
		}
		if (within) {
			memo[n][factors[0]][factors[1]][factors[2]][factors[3]] = ret + 1;
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String tokens[] = in.readLine().split(" ");
		in.close();
		a = Long.parseLong(tokens[0]);
		b = Long.parseLong(tokens[1]);
		factors = new int[4];
		memo = new int[18][30][19][13][11];
		System.out.println(dprod(1, 0));
	}
}