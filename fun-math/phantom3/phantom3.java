import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.BitSet;

class FastReader extends BufferedReader {
	FastReader(Reader in) {
		super(in);
	}

	char nextChar() throws Exception {
		int c;
		while ((c = read()) < 33);
		return (char) c;
	}

	double nextDouble() throws Exception {
		int c;
		double div = 1;
		double ret = 0;
		while ((c = read()) < 33);
		boolean neg = c == 45;
		if (neg) {
			c = read();
		}
		do {
			ret = ret * 10 + c - 48;
		} while ((c = read()) > 47 && c < 58);
		if (c == 46) {
			while ((c = read()) > 47 && c < 58) {
				ret += (c - 48) / (div *= 10);
			}
		}
		return neg ? -ret : ret;
	}

	int nextInt() throws Exception {
		int c;
		int ret = 0;
		while ((c = read()) < 33);
		boolean neg = c == 45;
		if (neg) {
			c = read();
		}
		do {
			ret = ret * 10 + c - 48;
		} while ((c = read()) > 47 && c < 58);
		return neg ? -ret : ret;
	}

	long nextLong() throws Exception {
		int c;
		long ret = 0;
		while ((c = read()) < 33);
		boolean neg = c == 45;
		if (neg) {
			c = read();
		}
		do {
			ret = ret * 10 + c - 48;
		} while ((c = read()) > 47 && c < 58);
		return neg ? -ret : ret;
	}
}

public class phantom3 {
	public static void main(String[] args) throws Exception {
		FastReader in = new FastReader(new InputStreamReader(System.in));
		long n = in.nextLong();
		long m = in.nextLong();
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