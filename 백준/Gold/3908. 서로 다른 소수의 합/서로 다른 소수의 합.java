import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1120;
    static boolean[] notPrime = new boolean[MAX + 1];
    static List<Integer> prime = new ArrayList<>();
    static int[][] dp = new int[MAX + 1][15];

    // 에라토스테네스의 체를 사용하여 MAX까지의 소수를 모두 구한다.
    static void eratosthenes() {
    	notPrime[0] = notPrime[1] = true;
        for (int i = 2; i <= MAX; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        
        for (int i = 2; i <= MAX; i++) if (!notPrime[i]) prime.add(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        eratosthenes();
        dp[0][0] = 1;

        for (int i : prime) {
            for (int j = MAX; j >= i; j--) {
                for (int k = 1; k <= 14; k++) {
                    dp[j][k] += dp[j - i][k - 1];
                }
            }
        }
        
        int tc = Integer.parseInt(br.readLine());
        while (tc --> 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            System.out.println(dp[n][k]);
        }
    }
}
