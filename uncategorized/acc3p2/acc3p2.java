import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class acc3p2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long[][] a = new long[n][2];
		long[] d = new long[n];
		long[] s = new long[n];
		for (int i = 0; i < n; i++) {
			String[] tokens = in.readLine().split(" ");
			a[i][0] = Long.parseLong(tokens[0]);
			a[i][1] = Long.parseLong(tokens[1]);
			d[i] = a[i][0] - a[i][1];
			s[i] = a[i][0] + a[i][1];
		}
		in.close();
		Arrays.sort(d);
		Arrays.sort(s);
		long out = 0;
		for (int i = 0; i < n; i++) {
			out += Math.max(Math.abs(a[i][0] - (d[n / 2] + s[n / 2] >> 1)), Math.abs(a[i][1] - s[n / 2] + (d[n / 2] + s[n / 2]) / 2));
		}
		System.out.println(out);
	}
}