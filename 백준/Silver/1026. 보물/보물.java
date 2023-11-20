import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr1 = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(st.nextToken());
		int[] arr2=  new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr2[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int ans = 0;
		for (int i = 0; i < n; i++) ans += arr1[i] * arr2[n-1-i];
		System.out.println(ans);
	
	
	}
	

}