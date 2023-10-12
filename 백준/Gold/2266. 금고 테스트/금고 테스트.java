import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Main {
    static int minTrials(int n, int k)
    {
        int dp[] = new int[n + 1], m;
        for (m = 0; dp[n] < k; m++) {
            for (int x = n; x > 0; x--) {
                dp[x] += 1 + dp[x - 1];
            }
        }
        return m;
    }
 
    public static void main(String[] args) throws IOException
    {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
        System.out.println(minTrials(k, n));
    }
}