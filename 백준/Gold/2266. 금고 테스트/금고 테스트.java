import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	int c = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	
    	int[][] dp = new int[r+1][c+1];
    	for (int i = 0; i <= c; i++) dp[1][i] = i;
    	for (int i = 0; i <= r; i++) dp[i][1] = 1;
    	
    	for (int i = 2; i <= r; i++) for (int j = 2; j <= c; j++) dp[i][j] = Integer.MAX_VALUE;
    	
    	for (int i = 2; i <= r; i++) 
    		for (int j = 2; j <= c; j++) 
    			for (int k = 1; k < j; k++) 
    				dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k-1], dp[i][j-k]) + 1);
    	
//    	for (int i = 0; i <= r; i++) System.out.println(Arrays.toString(dp[i]));
    	System.out.println(dp[r][c]);
    	
	}
}