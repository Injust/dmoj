import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

public class aplusb2 {
	public static void main(String[] args) throws Exception {
		FastReader in = new FastReader(new InputStreamReader(System.in));
		int a = in.nextInt();
		for (int i = 0; i < a; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			StringBuilder out = new StringBuilder();
			StringBuilder out2 = new StringBuilder();
			boolean lneg, sneg;
			int carry = 0;
			int carry2 = 0;
			String s = st.nextToken();
			String l = st.nextToken();
			if (sneg = s.charAt(0) < 46) {
				s = s.substring(1);
			}
			if (lneg = l.charAt(0) < 46) {
				l = l.substring(1);
			}
			char[] rep = new char[Math.max(l.length() - s.length(), 0)];
			Arrays.fill(rep, '0');
			s = new String(rep) + s;
			rep = new char[Math.max(s.length() - l.length(), 0)];
			Arrays.fill(rep, '0');
			l = new String(rep) + l;
			if (sneg ^ lneg) {
				if (sneg) {
					String temp = l;
					l = s;
					s = temp;
				}
				int sum = carry + s.charAt(s.length() - 1) - l.charAt(s.length() - 1) + 48;
				int sum2 = carry2 + s.charAt(s.length() - 1) - l.charAt(s.length() - 1) + 48;
				carry = 0;
				if (sum < 48) {
					sum += 10;
					carry = -1;
				}
				if (sum2 < 48) {
					sum2 += 10;
				}
				carry2 = carry;
				out.insert(0, (char) sum);
				if (sum2 == 48) {
					sum2 += 10;
					carry2--;
				}
				out2.insert(0, (char) sum2);
				for (int j = s.length() - 2; j >= 0; j--) {
					sum = carry + s.charAt(j) - l.charAt(j) + 48;
					sum2 = carry2 + s.charAt(j) - l.charAt(j) + 48;
					carry = 0;
					if (sum < 48) {
						sum += 10;
						carry = -1;
					}
					if (sum2 < 48) {
						sum2 += 10;
					}
					carry2 = carry;
					out.insert(0, (char) sum);
					out2.insert(0, (char) sum2);
				}
			} else {
				for (int j = s.length() - 1; j >= 0; j--) {
					int sum = carry + s.charAt(j) + l.charAt(j) - 48;
					carry = 0;
					if (sum > 57) {
						sum -= 10;
						carry = 1;
					}
					out.insert(0, (char) sum);
				}
				if (carry > 0) {
					out.insert(0, "1");
				}
			}
			String outS = out.toString();
			String out2S = out2.toString();
			if (carry < 0) {
				out2S = out2S.replaceAll("^9+", "");
				if (out2S.equals(":")) {
					System.out.println("0");
				} else {
					if (out2S.length() == 0) {
						out2S = "9";
					}
					System.out.print('-');
					for (int z = 0; z < out2S.length() - 1; z++) {
						System.out.print((char) (105 - out2S.charAt(z)));
					}
					System.out.println((char) (106 - out2S.charAt(out2S.length() - 1)));
				}
			} else {
				if (sneg && lneg) {
					System.out.print("-");
				}
				outS = outS.replaceAll("^0+", "");
				if (outS.length() == 0) {
					outS = "0";
				}
				System.out.println(outS);
			}
		}
		in.close();
	}
}