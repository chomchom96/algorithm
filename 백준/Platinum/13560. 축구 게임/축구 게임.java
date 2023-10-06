import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        boolean flag = true;
        int sum = 0;
        for (int idx = 1; idx <= n; idx++) {
        	sum += arr[n - idx];
        	if (sum > n * idx - (idx) * (idx + 1) / 2) {
        		flag = false; break;
        	}
        }
        if (sum != (n) * (n - 1) / 2) flag = false;
        System.out.println(flag? 1: -1);
    }
}