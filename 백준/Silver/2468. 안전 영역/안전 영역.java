import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, ans, cnt, day;
	static int[][] graph;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visited;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    	n = Integer.parseInt(br.readLine());
    	graph = new int[n][n];
    	int max = 0;
    	for (int i = 0 ; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < n; j++) {
    			graph[i][j] = Integer.parseInt(st.nextToken());
    			max = Math.max(graph[i][j], max);
    		}
    	}
    	ans = 1;
    	for (int d = 1; d <= max; d++) {
    		day = d;
    		visited = new boolean[n][n];
    		
    		cnt = 0;
    		for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (valid(i, j)) {
    			cnt++; dfs(i, j);
    		}
    		if (ans <= cnt) ans = cnt;
    	}
    	
    	System.out.println(ans);
    }
    
    static void dfs(int r, int c) {
    	visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (!valid(nr,nc)) continue;
			dfs(nr, nc);
		}
		return;
    }
    
    static boolean valid(int r, int c) {
    	if (r < 0 || r >= n || c < 0 || c >= n) return false;
    	if (visited[r][c] || graph[r][c] <= day) return false;
    	return true;
    }
}