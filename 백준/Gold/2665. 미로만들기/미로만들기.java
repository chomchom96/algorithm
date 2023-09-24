import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    
    static int n;
    static int[][] board;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] dist;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            String temp = br.readLine();
            Arrays.fill(dist[i], 2501);
            for(int j = 0; j < n; j++) board[i][j] = temp.charAt(j) - '0';
        }
        
        bfs();
        
        System.out.println(dist[n - 1][n - 1]);
    }
    
    
    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0,0});
        dist[0][0] = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(isValid(nr, nc)) if (dist[nr][nc] > dist[cur[0]][cur[1]]) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + (1 - board[cur[0]][cur[1]]);
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
    }
    
    static boolean isValid(int r, int c) {
    	if (r >= 0 && c >= 0 && r < n && c < n) return true;
    	return false;
    }
}