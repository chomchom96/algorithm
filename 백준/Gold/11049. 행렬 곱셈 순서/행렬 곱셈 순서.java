import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = a;
			arr[i + 1] = b;
		}

		int[][] dp = new int[n + 1][n + 1];

		for (int len = 2; len <= n; len++) {
			for (int i = 0; i + len <= n; i++) {
				int j = i + len;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i + 1; k < j; k++) {
					int value = dp[i][k] + dp[k][j] + (arr[i] * arr[k] * arr[j]);
					dp[i][j] = Math.min(dp[i][j], value);
				}
			}
		}
		System.out.println(dp[0][n]);
	}
}
