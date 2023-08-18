import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int cnt, R, C;

	static int[][] map;
	final static int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
    final static int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
	static boolean[][] visited;
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        do {
        	C = sc.nextInt();
            R = sc.nextInt();
            if (C == 0 && R == 0) System.exit(0);
        	map = new int[R][C];
        	visited = new boolean[R][C];
        	for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) map[i][j] = sc.nextInt();
        	cnt = 0;
        	for (int i = 0; i < R; i++) for (int j = 0; j < C; j++) if (map[i][j] == 1 && !visited[i][j]) bfs(i,j);
        	System.out.println(cnt);
        } while (R != 0 && C != 0);
    }
    
    static void bfs(int r, int c) {
    	cnt++;
    	visited[r][c] = true;
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {r,c});
    	while (!queue.isEmpty()) {
    		int[] cur = queue.poll();
    		int rr = cur[0];
    		int cc=  cur[1];
    		for (int i = 0; i < 8; i++) {
        		int nr = rr + dr[i];
        		int nc = cc + dc[i];
        		if (valid(nr,nc)) {
        			visited[nr][nc] = true;
        			queue.add(new int[] {nr,nc});
        		}
        	}
    	}
    	
    }
    static boolean valid(int r, int c) {
    	if (r < 0 || R <= r || c < 0 || C <= c) return false;
    	else if (visited[r][c] || map[r][c] == 0) return false;
    	return true;
    }
}