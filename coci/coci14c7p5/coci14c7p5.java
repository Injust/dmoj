import java.io.BufferedReader;
import java.io.InputStreamReader;

public class coci14c7p5 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = in.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        tokens = in.readLine().split(" ");
        in.close();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        double low = 0;
        double high = 1000000;
        double[] psa = new double[n + 1];
        while (high - low > 0.001) {
            double mid = (low + high) / 2;
            for (int i = 1; i <= n; i++) {
                psa[i] = psa[i - 1] + arr[i - 1] - mid;
            }
            double lowest = 0;
            for (int i = k; i <= n; i++) {
                if (psa[i] > lowest) {
                    low = mid;
                    break;
                }
                lowest = Math.min(lowest, psa[i - k + 1]);
            }
            if (low != mid) {
                high = mid;
            }
        }
        System.out.println(low);
    }
}