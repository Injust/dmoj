import java.io.BufferedReader;
import java.io.InputStreamReader;

public class utso18p6 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = in.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int q = Integer.parseInt(tokens[1]);
		tokens = in.readLine().split(" ");
		int[] val = new int[1 << n];
		for (int i = 0; i < 1 << n; i++) {
			val[i] = Integer.parseInt(tokens[i]);
		}
		for (int i = 0; i < q; i++) {
			tokens = in.readLine().split(" ");
			int a = Integer.parseInt(tokens[0]);
			int b = Integer.parseInt(tokens[1]);
			int c = Integer.parseInt(tokens[2]);
			if (a < 2) {
				val[b] = c;
			} else if ((b | c) > c) {
				System.out.println(0);
			} else {
				long out = val[b];
				c ^= b;
				int j = c;
				while ((j | b) > b) {
					out += val[j | b];
					j = (j - 1) & c;
				}
				System.out.println(out);
			}
		}
	}
}