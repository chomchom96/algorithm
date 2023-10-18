import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	static StringTokenizer st;
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		TreeMap<Integer, PriorityQueue<Integer>> cats = new TreeMap<>();
		int t = Integer.parseInt(br.readLine());
		// r, c 를 오름차순으로 자동정렬
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (r > n || c > m) continue;
			if (cats.get(r) == null) cats.put(r, new PriorityQueue<Integer>());
			cats.get(r).offer(c);
		}
		// r 기준으로 뽑으면서 LIS 생성
		int[] lis = new int[t + 1];
		int len = 1;
		for (int row : cats.keySet()) {
			PriorityQueue<Integer> q = cats.get(row);
			while (!q.isEmpty()) {
				int c = q.poll();
				if (lis[len - 1] <= c) lis[len++] = c; // 다음 입력값이 더 크면
				else {
					int l = 0, r = len; // 이분 탐색 시작
					while(l < r) {
						int mid = (l + r) / 2;
						if (lis[mid] <= c) l = mid + 1;
						else r = mid;
					}
					lis[r] = c;
				}
			}
		}
//		System.out.println(Arrays.toString(lis));
		System.out.println(len - 1);
	}
}