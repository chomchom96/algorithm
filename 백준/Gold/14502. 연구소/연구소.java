import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] cboard;
	static boolean[][] visited;
	static int n, m;
	static StringTokenizer st;
	static final int[] dr = {1,0,-1,0};
	static final int[] dc = {0,1,0,-1};
	static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cboard = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				cboard[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		dfs(0);
		
		System.out.println(ans);
	}
	
	static void dfs(int wallCount) { // 백트래킹 // 이게 맞나?
		if (wallCount == 3) {
			bfs(); return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cboard[i][j] == 0) {
					cboard[i][j] = 1;
					dfs(wallCount + 1);
					cboard[i][j] = 0;
				}
			}
		}
		
	}
	
	static void bfs() {
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) System.out.print(cboard[i][j]);
//			System.out.println();
//		}
//		System.out.println();
		visited = new boolean[n][m];
		int area = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (cboard[r][c] == 2) {
					visited[r][c] = true;
					queue.add(new int[] {r,c});
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int[] virus = queue.poll();
			int r = virus[0];
			int c = virus[1];
			for (int i = 0 ; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (isValid(nr,nc) && cboard[nr][nc] == 0) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc});
				}
			}
		}
		
		area = countSafe(visited);
		ans = Math.max(ans, area);
		return;
	}
	
	static boolean isValid(int r, int c) {
		if (r < 0 || r >= n || c < 0 || c >= m) return false;
		if (visited[r][c]) return false;
		if (cboard[r][c] != 0) return false;
		return true;
	}
	
	static int countSafe(boolean[][] visited) {
		int cnt = 0;
		for (int i = 0; i < n; i++) for (int j = 0; j < m; j++){
			if (!visited[i][j] && cboard[i][j] == 0) cnt++;
		}
		return cnt;
	}	
}