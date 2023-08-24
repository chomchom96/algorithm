import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] str1 = br.readLine().toCharArray();
        char[] str2=  br.readLine().toCharArray();
		int n = str1.length;
		int m = str2.length;
		int[][] dp = new int[n+1][m+1];
		char[][] dp2 = new char[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1[i-1] == str2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					dp2[i][j] = str1[i-1];
				}
				else {
					if (dp[i][j-1]> dp[i-1][j]) {
						dp[i][j] = dp[i][j-1];
						dp2[i][j] = dp2[i][j-1];
					    }
					else {
						dp[i][j] = dp[i-1][j];
						dp2[i][j] = dp2[i-1][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dp[n][m] + "\n");
		Stack<Character> stack = new Stack<>();
		while (n>0 && m>0) {
			
			if (dp[n][m] == dp[n-1][m]) n--;
			else if (dp[n][m] == dp[n][m-1]) m--;
			else {
				stack.push(dp2[n][m]);
				n--; m--;
			}
		}
		while (!stack.isEmpty()) sb.append(stack.pop());
		bw.write(sb.toString());
		bw.close();
    }
}