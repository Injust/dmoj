import java.io.BufferedReader;
import java.io.InputStreamReader;

public class dmpg17g2 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = in.readLine().split(" ");
		int n = Integer.parseInt(tokens[0]);
		int q = Integer.parseInt(tokens[1]);
		int[] swords = new int[n];
		tokens = in.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			swords[i] = Integer.parseInt(tokens[i]);
		}
		for (int i = 0; i < q; i++) {
			tokens = in.readLine().split(" ");
			if (tokens[0].equals("S")) {
				swords[Integer.parseInt(tokens[1]) - 1] = Integer.parseInt(tokens[2]);
			} else if (tokens[0].equals("Q")) {
				long have = 0;
				long high = -1000000000;
				for (int j = Integer.parseInt(tokens[1]) - 1; j < Integer.parseInt(tokens[2]); j++) {
					have += swords[j];
					high = have > high ? have : high;
					have = have < 0 ? 0 : have;
				}
				System.out.println(high);
			}
		}
		in.close();
	}
}