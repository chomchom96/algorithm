import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		Deque<int[]> deque = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(st.nextToken());
			while (!deque.isEmpty() && deque.peekLast()[0] > cur) {
				deque.pollLast();
			}
			deque.offer(new int[] {cur, i});
			while (deque.peek()[1] <= i - l) deque.pollFirst();
//			for (int[] a : deque) System.out.println(Arrays.toString(a));
			sb.append(deque.peek()[0] + " ");
		}
		System.out.println(sb);
	}
}