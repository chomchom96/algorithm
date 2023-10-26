import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		Deque<Integer> d1 = new ArrayDeque<>();
		Deque<Integer> d2 = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) d1.add(arr[i]);
			else d2.add(arr[i]);
		}
		int sum = 0;
		int[] ans = new int[n];
		int mid = n % 2 == 0? n/2: n/2 + 1;
		for (int i = 0 ; i < mid; i++) ans[i] = d1.poll();
		for (int i = mid; i < n; i++) ans[i] = d2.pollLast();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(ans[i] + " ");
			if (i != n - 1) sum += ans[i] * ans[i+1];
			if (i == n - 1) sum += ans[i] * ans[0];
		}
		System.out.println(sum);
		System.out.println(sb);
	}
}