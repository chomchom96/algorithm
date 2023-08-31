import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][][] dp = new int[n][3][3];


        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 3; j++) {
        		dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = Integer.parseInt(st.nextToken());
        	}
        }


        dp[0][0][1] = dp[0][0][2] = dp[0][1][0] = dp[0][1][2] = dp[0][2][0] = dp[0][2][1] = 2001;
        
        for (int i = 1; i < n; i++) {
        	for (int j = 0; j < 3; j++) {
	        	dp[i][0][j] += Math.min(dp[i-1][1][j], dp[i-1][2][j]);
	        	dp[i][1][j] += Math.min(dp[i-1][0][j], dp[i-1][2][j]);
	        	dp[i][2][j] += Math.min(dp[i-1][0][j], dp[i-1][1][j]);
        	}
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
        	for (int i = 0; i < 3; i++) {
        		if (i != k) ans = Math.min(ans,  dp[n-1][i][k]);
        	}
        }
        System.out.println(ans);
    }
}