import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;

public class coci07c5p4 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[][] grid = new int[3][n];
        ArrayList<Integer>[] cols = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            cols[i] = new ArrayList<>();
        }
        int[][] rowFreq = new int[3][n];
        for (int y = 0; y < 3; y++) {
            String[] tokens = in.readLine().split(" ");
            for (int x = 0; x < n; x++) {
                grid[y][x] = Integer.parseInt(tokens[x]) - 1;
                cols[grid[y][x]].add(x);
                rowFreq[y][grid[y][x]]++;
            }
        }
        in.close();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int x = 0; x < n; x++) {
            if (rowFreq[1][x] == 0 || rowFreq[2][x] == 0) {
                queue.push(x);
            }
        }
        BitSet deleted = new BitSet(n);
        int out = 0;
        while (!queue.isEmpty()) {
            int target = queue.pop();
            for (int x : cols[target]) {
                if (!deleted.get(x)) {
                    for (int y = 0; y < 3; y++) {
                        if (--rowFreq[y][grid[y][x]] == 0) {
                            queue.push(grid[y][x]);
                        }
                    }
                    deleted.set(x);
                    out++;
                }
            }
        }
        System.out.println(out);
    }
}