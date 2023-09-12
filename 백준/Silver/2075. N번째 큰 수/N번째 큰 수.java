import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static long[][] board;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		board = new long[n][n];
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) board[i][j] = Long.parseLong(st.nextToken());
		}
		
		PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) ->(int) (o2[2] - o1[2]));
		for (int i = 0; i < n; i++) pq.add(new long[] {n-1, i, board[n-1][i]});
		int cnt = 0;
		while (true) {
			long[] cur = pq.poll();
			
			int r = (int) cur[0];
			int c = (int) cur[1];
			long value = cur[2];
			if (!visited[r][c]) cnt++;
			visited[r][c] = true;
			
			if (cnt >= n) {
				System.out.println(value);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
				if (visited[nr][nc]) continue;
				pq.add(new long[] {nr, nc, board[nr][nc]});
			}
			
		}
		
		}

}