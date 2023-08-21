import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i =1; i <= n; i++) {
			dp[i] = (dp[i-1] + (m-1)) % i + 1;
		}
		System.out.println(dp[n]);
	}
}