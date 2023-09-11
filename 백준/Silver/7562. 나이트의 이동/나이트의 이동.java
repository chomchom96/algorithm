import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {1,2,2,1,-1,-2,-2,-1};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	static int l;
	static int[][] board;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		while (TC --> 0) {
			l = Integer.parseInt(br.readLine());
			
			board = new int[l][l];
			visited = new boolean[l][l];
			
			StringTokenizer st;
			st= new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			int fr = Integer.parseInt(st.nextToken());
			int fc = Integer.parseInt(st.nextToken());
			bfs(sr, sc, fr, fc);
			
		}
	}
	
	static void bfs(int sr, int sc, int fr, int fc) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {sr, sc, 0});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == fr && cur[1] == fc) {
				System.out.println(cur[2]);
				return;
			}
			
			visited[cur[0]][cur[1]] = true;
			for (int i = 0; i < 8; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (valid(nr, nc)) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc, cur[2] + 1});
				}
				
			}
		}
	}
	
	static boolean valid(int r, int c) {
		if (r < 0 || l <= r || c < 0 || l <= c) return false;
		if (visited[r][c]) return false;
		return true;
	}
}