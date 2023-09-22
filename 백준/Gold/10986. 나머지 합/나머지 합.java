import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n + 1];
		long[] cnt = new long[m];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= n; i++) {
			arr[i] = (arr[i-1] + Integer.parseInt(st.nextToken()) % m) % m;
			cnt[arr[i]]++;
		}
		
		long sum = 0;
		sum += cnt[0] * (cnt[0] + 1) / 2;
		for (int i = 1; i < m; i++) sum += cnt[i] * (cnt[i] - 1) / 2;
		System.out.println(sum);
	}
	
}