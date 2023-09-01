import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) arr[i] = Integer.parseInt(br.readLine());
        
        int start = (n - m > 0)? 0: m - n;
        Arrays.sort(arr);
        int price = 0;
        int max = 0;
        for (int i = start; i < m; i++) {
        	if (arr[i] * (m - i) > max) {
        		max = arr[i] * (m-i);
        		price = arr[i];
        	}
        }
        System.out.println(price + " " + max);
    }
}