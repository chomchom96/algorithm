import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuffer sb = new StringBuffer();
    static int[][] dp = new int[51][51];

    static void swap(int from, int to) {
        char temp = sb.charAt(from);
        sb.setCharAt(from, sb.charAt(to));
        sb.setCharAt(to, temp);
    }

    public static void DP(int from, int to) {
        swap(from, to);

        for (int i = 0; i < sb.length(); i++) {
            dp[i][i] = 0;
            if (i < sb.length() - 1) {
                if (sb.charAt(i) == sb.charAt(i + 1)) dp[i][i + 1] = 0; // 바꿀 필요 없음
                else dp[i][i + 1] = 1;
            }
        }

        for (int i = 2; i < sb.length(); i++) {
            for (int j = 0; j + i < sb.length(); j++) {
                dp[j][j + i] = Math.min(dp[j + 1][j + i] + 1, dp[j][j + i - 1] + 1);
                if (sb.charAt(j + i) == sb.charAt(j)) dp[j][j + i] = Math.min(dp[j + 1][j + i - 1], dp[j][j + i]);
                else dp[j][j + i] = Math.min(dp[j + 1][j + i - 1] + 1, dp[j][j + i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = Integer.MAX_VALUE;

        sb.append(br.readLine().trim());

        DP(0,0);
        ans = dp[0][sb.length()-1];

        for (int i = 0; i < sb.length(); i++) {
            for (int j = i + 1; j < sb.length(); j++) {
                DP(i, j);
                ans = Math.min(ans, dp[0][sb.length() - 1] + 1);
                swap(i, j);
            }
        }
        System.out.println(ans);
    }
}