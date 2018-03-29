import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class BIT {
	private int[] data;
	private int length;

	BIT(int length) {
		data = new int[length + 1];
		this.length = length;
	}

	void add(int ind) {
		for (; ind <= length; ind += -ind & ind) {
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
		long[] psa = new long[n + 1];
		long[][] lookup = new long[n + 1][2];
		for (int i = 1; i <= n; i++) {
			psa[i] = psa[i - 1] + Integer.parseInt(tokens[i - 1]) - p;
			lookup[i][0] = psa[i];
			lookup[i][1] = i;
		}
		Arrays.sort(lookup, Comparator.<long[]>comparingLong(a -> a[0]).thenComparingLong(a -> a[1]));
		BIT bit = new BIT(n + 1);
		int left = 0;
		long out = 0;
		for (int right = 0; right <= n; right++) {
			while (left < right && lookup[right][0] >= lookup[left][0]) {
				bit.add((int) lookup[left++][1] + 1);
			}
			out += bit.query((int) lookup[right][1] + 1);
		}
		System.out.println(out);
	}
}