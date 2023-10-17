import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	
	static StringTokenizer st;
	static int n;
	static boolean[][] lighted;
	static boolean[][] visited;
	static ArrayDeque<int[]>[][] switches;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
    public static void main(String[] args) throws IOException {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	visited = new boolean[n+1][n+1];
    	lighted = new boolean[n+1][n+1];
    	lighted[1][1] = true;
    	switches = new ArrayDeque[n+1][n+1];
    	for (int i = 0; i <= n; i++) for (int j = 0; j <= n; j++) switches[i][j] = new ArrayDeque<int[]>();
    	int m = Integer.parseInt(st.nextToken());
    	while (m-->0) {
    		st = new StringTokenizer(br.readLine());
    		int a1 = Integer.parseInt(st.nextToken());
    		int a2 = Integer.parseInt(st.nextToken());
    		int b1 = Integer.parseInt(st.nextToken());
    		int b2 = Integer.parseInt(st.nextToken());
    		switches[a1][a2].add(new int[] {b1,b2});
    		
    	}
    	bfs();
    }

	private static void bfs() {
		int cnt = 1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {1,1});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			visited[cur[0]][cur[1]] = true;
			ArrayDeque<int[]> curLight = switches[cur[0]][cur[1]];
			while (!curLight.isEmpty()) {
				visited = new boolean[n+1][n+1];
				int[] light = curLight.poll();
				int lr = light[0];
				int lc = light[1];
				if (!lighted[lr][lc]) cnt++;
				lighted[lr][lc] = true;
			
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr >= 1 && nr <= n && nc >= 1 && nc <= n) if (lighted[nr][nc] && !visited[nr][nc]) {
					queue.add(new int[] {nr, nc});
					visited[nr][nc] = true;
				}
			}
		}
		System.out.println(cnt);
	}
}