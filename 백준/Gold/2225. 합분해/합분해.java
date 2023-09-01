import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n+1][k+1];
        for (int i = 0; i <= n; i++) arr[i][0] = 1L;
        for (int i = 0; i <= k; i++) arr[0][i] = 1L;
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= k; j++) {
        		for (int range = 0; range <= i; range++) {
        			arr[i][j] += arr[range][j-1];
        			arr[i][j] %= 1000000000;
        		}
        	}
        }
        System.out.println(arr[n][k-1] % 1000000000);
    }
}