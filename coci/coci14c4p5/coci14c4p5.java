import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;

public class coci14c4p5 {
    private static int[] argue;
    private static ArrayList<Integer>[] group;
    private static BitSet party;

    private static void recurse(int at) {
        if (argue[at] > 2) {
            argue[at] = 0;
            party.flip(at);
            for (int adj : group[at]) {
                if (party.get(at) == party.get(adj)) {
                    argue[at]++;
                    argue[adj]++;
                    if (argue[adj] > 2) {
                        recurse(adj);
                    }
                } else {
                    argue[adj]--;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        argue = new int[n];
        group = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            group[i] = new ArrayList<>();
        }
        party = new BitSet(n);
        for (int i = 0; i < 5; i++) {
            String[] tokens = in.readLine().split(" +");
            int m = Integer.parseInt(tokens[0]);
            for (int j = 1; j <= m; j++) {
                int l = Integer.parseInt(tokens[(j << 1) - 1]) - 1;
                int r = Integer.parseInt(tokens[j << 1]) - 1;
                argue[l]++;
                argue[r]++;
                group[l].add(r);
                group[r].add(l);
            }
        }
        in.close();
        for (int i = 0; i < n; i++) {
            recurse(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(party.get(i) ? 'A' : 'B');
        }
    }
}