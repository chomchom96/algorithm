import java.util.Scanner;
 
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
 
    /* Driver code*/
    public static void main(String[] args)
    {	
    	Scanner sc = new Scanner(System.in);	
    	int n = sc.nextInt();
    	int k = sc.nextInt();
        System.out.println(minTrials(k, n));
    }
}