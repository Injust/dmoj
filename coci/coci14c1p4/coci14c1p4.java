import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class coci14c1p4 {
	private static int[] accuse;
	private static int[] accusations;
	private static BitSet visited;
	private static int out;

	private static void dfs(int accuser, boolean mobster) {
		if (!visited.get(accuser)) {
			visited.flip(accuser);
			if (mobster) {
				out++;
			}
			accusations[accuse[accuser]]--;
			if (mobster || accusations[accuse[accuser]] == 0) {
				dfs(accuse[accuser], !mobster);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		accuse = new int[n];
		accusations = new int[n];
		for (int accuser = 0; accuser < n; accuser++) {
			int accused = Integer.parseInt(in.readLine()) - 1;
			accuse[accuser] = accused;
			accusations[accused]++;
		}
		visited = new BitSet(n);
		for (int accuser = 0; accuser < n; accuser++) {
			if (accusations[accuser] == 0) {
				dfs(accuser, true);
			}
		}
		for (int accuser = 0; accuser < n; accuser++) {
			dfs(accuser, false);
		}
		System.out.println(out);
	}
}