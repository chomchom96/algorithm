import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->(o2[2] - o1[2]));
		
		for (int i = 0; i < n; i++) pq.add(new int[] {n-1, i, board[n-1][i]});
		
		int cnt = n - 1;
		while (cnt --> 0) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int nr = r - 1;
			pq.add(new int[] {nr, c, board[nr][c]});
		}
		System.out.println(pq.peek()[2]);
	}
}