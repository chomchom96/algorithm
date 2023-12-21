import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static boolean[][] visited;
  static int[][] map;
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  static Queue<int[]> queue = new ArrayDeque<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
        	int height = Integer.parseInt(st.nextToken());
        	map[i][j] = height;
        	if (height != 0) queue.offer(new int[] {i, j});
        }
    }
    int day = 0;
    l: while (true) {
    	int cnt = 0;
    	boolean flag = false;
    	visited = new boolean[n][m];
    	for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) {
    		if (cnt >= 2) break l;
    		if (map[i][j] > 0 && !visited[i][j]) {
    			dfs(i, j);
    			cnt++;
    			flag = true;
    		}
    	}
    	if (!flag) {
    		day = 0; break l;
    	}
    	melt();
    	day++;
    }
    System.out.println(day);
    
  }

	private static void melt() {
		int num = queue.size();
		while (num --> 0) {
			int[] ice = queue.poll();
			int r = ice[0];
			int c = ice[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (isValid(nr, nc)) if (!visited[nr][nc]) map[r][c]--;
			}
			if (map[r][c] > 0) queue.offer(new int[] {r,c});
			
		}
	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isValid(nr, nc)) if (!visited[nr][nc] && map[nr][nc] > 0) dfs(nr, nc);
		}
	}
	
	private static boolean isValid(int r, int c) {
		if (r < 0 || r >= n || c < 0 || c >= m) return false;
		return true;
	}
}