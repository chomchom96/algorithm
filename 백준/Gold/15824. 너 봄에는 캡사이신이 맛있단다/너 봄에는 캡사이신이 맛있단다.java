import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int MOD = 1000000007;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[] pows = new long[n];
        pows[0] = 1L;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	if (i > 0) pows[i] = (pows[i - 1] * 2) % MOD;
        }
        
        Arrays.sort(arr);
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
			sum = (sum + arr[i] * (-pows[n-1-i] + pows[i])) % MOD;
		}
        System.out.println(sum % MOD); 
    }
}