import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(in.readLine());
		String s, l;
		for (int i = 0; i < a; i++) {
			String[] tokens = in.readLine().split(" ");
			StringBuilder out = new StringBuilder();
			StringBuilder out2 = new StringBuilder();
			String temp;
			int carry = 0;
			int carry2 = 0;
			int sum, sum2;
			s = tokens[0];
			l = tokens[1];
			boolean sneg, lneg;
			if (sneg = s.charAt(0) == '-') {
				s = s.substring(1);
			}
			if (lneg = l.charAt(0) == '-') {
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
					temp = l;
					l = s;
					s = temp;
				}
				sum = carry + s.charAt(s.length() - 1) - l.charAt(s.length() - 1) + '0';
				sum2 = carry2 + s.charAt(s.length() - 1) - l.charAt(s.length() - 1) + '0';
				carry = 0;
				if (sum < '0') {
					sum += 10;
					carry = -1;
				}
				if (sum2 < '0') {
					sum2 += 10;
				}
				carry2 = carry;
				out.insert(0, (char) sum);
				if (sum2 == '0') {
					sum2 += 10;
					carry2 -= 1;
				}
				out2.insert(0, (char) sum2);
				for (int j = s.length() - 2; j >= 0; j--) {
					sum = carry + s.charAt(j) - l.charAt(j) + '0';
					sum2 = carry2 + s.charAt(j) - l.charAt(j) + '0';
					carry = 0;
					if (sum < '0') {
						sum += 10;
						carry = -1;
					}
					if (sum2 < '0') {
						sum2 += 10;
					}
					carry2 = carry;
					out.insert(0, (char) sum);
					out2.insert(0, (char) sum2);
				}
			} else {
				for (int j = s.length() - 1; j >= 0; j--) {
					sum = carry + s.charAt(j) + l.charAt(j) - '0';
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
	}
}