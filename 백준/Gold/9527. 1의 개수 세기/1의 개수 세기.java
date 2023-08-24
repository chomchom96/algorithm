
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long[] DP = calculateDp();
        
        long result = calRange(M, DP) - calRange(N - 1, DP);
        System.out.print(result);
    }

    static long calRange(long N, long[] DP) {
        long count = N % 2;
        int size = (int) (Math.log(N) / Math.log(2));

        for (int i = size; i > 0; i--) {
            if ((N & (1L << i)) != 0L) {
                count += DP[i - 1] + (N - (1L << i) + 1);
                N -= (1L << i);
            }
        }
        
        return count;
    }

    static long[] calculateDp() {
        long[] DP = new long[55];
        DP[0] = 1;
        
        for (int i = 1; i < 55; i++) {
            DP[i] = (DP[i - 1] << 1) + (1L << i);
        }
        
        return DP;
    }
}
