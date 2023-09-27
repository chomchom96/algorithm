import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		while (T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			System.out.println(comb(n, r));
		}
	}
	
	static int comb(int n, int r) {
		int[][] dp = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			dp[i][0] = dp[i][i] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[i][j] == 0) dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		return dp[n][r];
	}
}