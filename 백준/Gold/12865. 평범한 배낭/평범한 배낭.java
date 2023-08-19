import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] item = new int[N + 1][2]; 

        for (int i = 1; i <= N; i++) {
             StringTokenizer st2 = new StringTokenizer(br.readLine());
            item[i][0] = Integer.parseInt(st2.nextToken());
            item[i][1] = Integer.parseInt(st2.nextToken());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int k = 1; k <= K; k++) { 
            for (int i = 1; i <= N; i++) { 
                dp[i][k] = dp[i - 1][k];
                if (k >= item[i][0] ) dp[i][k] = Math.max(dp[i-1][k], item[i][1] + dp[i-1][k-item[i][0]]);
            }
        }
        System.out.println(dp[N][K]);
    }
}