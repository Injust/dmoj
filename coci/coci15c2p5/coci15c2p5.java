import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class BIT {
	private int[] data;
	private int maxind;

	BIT(int maxind) {
		data = new int[maxind + 1];
		this.maxind = maxind;
	}

	void add(int ind) {
		for (; ind <= maxind; ind += -ind & ind) {
			data[ind]++;
		}
	}

	int query(int ind) {
		int ret = 0;
		for (; ind > 0; ind -= -ind & ind) {
			ret += data[ind];
		}
		return ret;
	}
}

public class coci15c2p5 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] tokens = in.readLine().split(" ");
		int p = Integer.parseInt(in.readLine());
		in.close();
		long[][] psa = new long[n + 1][2];
		for (int i = 1; i <= n; i++) {
			psa[i][0] = Integer.parseInt(tokens[i - 1]) + psa[i - 1][0] - p;
			psa[i][1] = i;
		}
		Arrays.sort(psa, Comparator.<long[]>comparingLong(a -> a[0]).thenComparingLong(a -> a[1]));
		BIT bit = new BIT(n + 1);
		long out = 0;
		for (long[] pair : psa) {
			out += bit.query((int) pair[1] + 1);
			bit.add((int) pair[1] + 1);
		}
		System.out.println(out);
	}
}