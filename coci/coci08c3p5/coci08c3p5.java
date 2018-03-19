import java.io.BufferedReader;
import java.io.InputStreamReader;

public class coci08c3p5 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		int[][] ll = new int[2][n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			ll[0][i + 1] = i;
			ll[1][i] = i + 1;
		}
		in.close();
		ll[1][0] = 0;
		int[][] adj = new int[n][2];
		for (int i = n - 1; i >= 0; i--) {
			adj[arr[i] - 1][0] = ll[0][arr[i]];
			adj[arr[i] - 1][1] = ll[1][arr[i]];
			ll[1][ll[0][arr[i]]] = ll[1][arr[i]];
			ll[0][ll[1][arr[i]]] = ll[0][arr[i]];
		}
		int[] depth = new int[n + 1];
		depth[0] = -1;
		long out = 0;
		for (int i : arr) {
			depth[i] = Math.max(depth[adj[i - 1][0]], depth[adj[i - 1][1]]) + 1;
			System.out.println(out += depth[i]);
		}
	}
}