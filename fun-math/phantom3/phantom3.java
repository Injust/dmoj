import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;

public class phantom3 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		long m = Long.parseLong(in.readLine());
		in.close();
		BitSet sieve = new BitSet(20000000);
		int size = (int) Math.ceil(Math.sqrt(m));
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 2; i < size; i++) {
			if (!sieve.get(i)) {
				primes.add(i);
				for (int j = i; j < size; j += i) {
					sieve.set(j);
				}
			}
		}
		sieve.clear();
		int out = 0;
		for (int prime : primes) {
			int min = (int) (n / prime * prime - n);
			if (min < 0) {
				min += prime;
			}
			for (; min < m - n; min += prime) {
				sieve.set(min);
			}
			if (prime >= n) {
				out++;
			}
		}
		System.out.println(out + m - n - sieve.cardinality());
	}
}