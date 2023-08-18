import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r, c, ans;
	static int[][] board;
	static boolean[] visited = new boolean[26];
	final static int[] dr = {1, 0, -1, 0};
    final static int[] dc = {0, 1, 0, -1};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new int[r][c];
        for (int i = 0; i < r; i++) {
        	String temp = br.readLine();
        	for (int j = 0; j < c; j++) board[i][j] = temp.charAt(j)- 'A';
        }
        backTrack(0,0,1);
        System.out.println(ans);
    }
    
    static void backTrack(int rr, int cc, int depth) {
    	visited[board[rr][cc]] = true;
    	for (int k = 0; k < 4; k++) {
    		int nr = rr + dr[k];
    		int nc = cc + dc[k];
    		if (valid(nr,nc)) {
    			backTrack(nr,nc,depth+1);
    			visited[board[nr][nc]] = false;
    			}
    		}
    		ans = Math.max(depth, ans);
    }
    
    
    static boolean valid(int nr, int nc) {
    	if (0 > nr || nr >= r || 0 > nc || nc >= c) return false;
    	else if (visited[board[nr][nc]]) return false;
    	return true;
    }
}