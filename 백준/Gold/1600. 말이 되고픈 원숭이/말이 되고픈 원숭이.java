import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, ans;
	static int[][] graph;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static int[] hr = {1,2,2,1,-1,-2,-2,-1};
	static int[] hc = {2,1,-1,-2,-2,-1,1,2};
	
	static boolean[][][] visited;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    	k = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	graph = new int[n][m];
    	for (int i = 0 ; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < m; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }
    	visited = new boolean[n][m][k+1];
    	ans = -1;
    	bfs(0, 0, k, 0);
    	System.out.println(ans);
    }
    
    static void bfs(int sr, int sc, int cnt, int move) {
    	visited[sr][sc][cnt] = true;
    	Queue<int[]> queue = new ArrayDeque<>();	
    	queue.offer(new int[] {sr, sc, cnt, move});
    	while (!queue.isEmpty()) {
    		int[] cur = queue.poll();
    		int r = cur[0];
    		int c = cur[1];
    		int hcnt = cur[2];
    		int mv = cur[3];
    		if (r == n - 1 && c == m - 1) {
    			ans = mv;
    			break;
    		}
    		if (hcnt > 0) {
    			for (int i = 0; i < 8; i++) {
    				int nhr = r + hr[i];
    				int nhc = c + hc[i];
    				if (valid(nhr, nhc)) if (!visited[nhr][nhc][hcnt - 1]) {
    					visited[nhr][nhc][hcnt - 1] = true;
    					queue.add(new int[] {nhr, nhc, hcnt - 1, mv + 1});
    				}
    			}
    		}
    		for (int i = 0; i < 4; i++) {
    			int nr = r + dr[i];
    			int nc = c + dc[i];
    			if (valid(nr, nc)) if (!visited[nr][nc][hcnt]) {
    				visited[nr][nc][hcnt] = true;
    				queue.add(new int[] {nr, nc, hcnt, mv + 1});
    			}
    		}
    	}
    	return;
    }
    
    static boolean valid(int r, int c) {
    	if (r < 0 || r >= n || c < 0 || c >= m) return false;
    	if (graph[r][c] == 1) return false;
    	return true;
    }
}