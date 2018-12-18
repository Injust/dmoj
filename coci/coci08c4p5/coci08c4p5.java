import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;

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

public class coci08c4p5 {
	private static int l;

	private static int blocked(ArrayList<Integer> factors) {
		int ret = 0;
		for (int mask = 1; mask < 1 << factors.size(); mask++) {
			boolean incl = false;
			int x = 1;
			for (int i = 0; i < factors.size(); i++) {
				if ((mask >> i & 1) == 1) {
					x = x / gcd(x, factors.get(i)) * factors.get(i);
					incl ^= true;
				}
			}
			if (incl) {
				ret += l / x;
			} else {
				ret -= l / x;
			}
		}
		return ret;
	}

	private static int gcd(int a, int b) {
		return (b > 0 ? gcd(b, a % b) : a);
	}

	public static void main(String[] args) throws Exception {
		FastReader in = new FastReader(new InputStreamReader(System.in));
		int a = in.nextInt();
		int b = in.nextInt();
		l = in.nextInt();
		in.close();
		ArrayList<Integer>[] factors = new ArrayList[a + b + 1];
		for (int i = 0; i <= a + b; i++) {
			factors[i] = new ArrayList<>();
			int x = i;
			for (int f = 2; f * f <= i; f++) {
				if (x % f == 0) {
					while (x % f == 0) {
						x /= f;
					}
					factors[i].add(f);
				}
			}
			if (x > 1) {
				factors[i].add(x);
			}
		}
		long[] out = new long[3];
		for (int i = 0; i <= a + b >> 1; i++) {
			int mul = i << 1 < a + b ? 2 : 1;
			int notA = i > 0 ? blocked(factors[i]) : l - 1;
			int notB = blocked(factors[a + b - i]);
			HashSet<Integer> temp = new HashSet<>();
			for (int aa : factors[i]) {
				for (int bb : factors[a + b - i]) {
					temp.add(aa == bb ? aa : aa * bb);
				}
			}
			int notAB = i > 0 ? blocked(new ArrayList<>(temp)) : notB;
			out[0] += mul * notAB;
			out[1] += mul * (notA + notB - (notAB << 1));
			out[2] += mul * (l - notA - notB + notAB);
		}
		for (long i : out) {
			System.out.println(i);
		}
	}
}