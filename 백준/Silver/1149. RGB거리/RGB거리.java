import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[3];
        int[] tmp = new int[3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tmp[0] = a + Math.min(dp[1], dp[2]);
            tmp[1] = b + Math.min(dp[0], dp[2]);
            tmp[2] = c + Math.min(dp[0], dp[1]);

            for (int j = 0; j < 3; j++) {
                dp[j] = tmp[j];
            }
        }

        int min = Math.min(dp[0], Math.min(dp[1], dp[2]));
        System.out.println(min);
    }
}
