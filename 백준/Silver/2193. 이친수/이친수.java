import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		if (n == 1 || n == 2) {
			System.out.println(1); System.exit(0);
		}
		Long[] dp = new Long[n];
		dp[0] = 1L; 
		dp[1] = 1L; 
		dp[2] = 2L; 
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n-1]);
	}
}
