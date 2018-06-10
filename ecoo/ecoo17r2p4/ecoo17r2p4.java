import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ecoo17r2p4 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int j = 0;
		int[] o = new int[10001];
		int[][] c = new int[2][10002];
		for (int i = 0; i < 10002; i++) {
			c[1][i] = 1;
		}
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(in.readLine());
			for (; j <= n; j++) {
				c[j & 1][0] = 0;
				for (int k = 0; k <= j; k++) {
					c[j & 1][k + 1] = ((k > 0 ? c[j & 1][k] : 0) + c[j & 1 ^ 1][j - k]) % 1000000007;
				}
				o[j] = c[j & 1][1];
			}
			System.out.println(o[n]);
		}
		in.close();
	}
}