import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(st.nextToken());
            for (int j = i; j <= N; j+=i) dp[i][j] = cost * j/i;
        }

        int ans = 0;

        for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) {
            dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
            if (j > i) {
                for (int k = 1; k < j; k++) dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[i][j-k]);
            }
            if (i == N) ans = Math.max(ans, dp[i][j]);
        }
        System.out.println(ans);
    }
}