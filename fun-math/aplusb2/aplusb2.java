import java.io.*;
import java.util.*;

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
	private static FastReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new FastReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int a = in.nextInt();
		for (int i = 0; i < a; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			StringBuilder ans = new StringBuilder();
			StringBuilder ans2 = new StringBuilder();
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
				ans.insert(0, (char) sum);
				if (sum2 == 48) {
					sum2 += 10;
					carry2--;
				}
				ans2.insert(0, (char) sum2);
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
					ans.insert(0, (char) sum);
					ans2.insert(0, (char) sum2);
				}
			} else {
				for (int j = s.length() - 1; j >= 0; j--) {
					int sum = carry + s.charAt(j) + l.charAt(j) - 48;
					carry = 0;
					if (sum > 57) {
						sum -= 10;
						carry = 1;
					}
					ans.insert(0, (char) sum);
				}
				if (carry > 0) {
					ans.insert(0, "1");
				}
			}
			String ansS = ans.toString();
			String ans2S = ans2.toString();
			if (carry < 0) {
				ans2S = ans2S.replaceAll("^9+", "");
				if (ans2S.equals(":")) {
					out.println("0");
				} else {
					if (ans2S.length() == 0) {
						ans2S = "9";
					}
					out.print('-');
					for (int z = 0; z < ans2S.length() - 1; z++) {
						out.print((char) (105 - ans2S.charAt(z)));
					}
					out.println((char) (106 - ans2S.charAt(ans2S.length() - 1)));
				}
			} else {
				if (sneg && lneg) {
					out.print("-");
				}
				ansS = ansS.replaceAll("^0+", "");
				if (ansS.length() == 0) {
					ansS = "0";
				}
				out.println(ansS);
			}
		}
		in.close();
		out.close();
	}
}