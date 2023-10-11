import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, rs, re, sum;
	static int[][] map;
	static boolean flag;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static List<int[]> list;
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        rs = Integer.parseInt(st.nextToken());
        re = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        while (true) {
        	flag = false;
        	visited = new boolean[n][n];
        	for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) {
        		list = new ArrayList<>();
        		sum = 0;
        		dfs(i, j);
        		if (list.size() > 1) {
        			flag = true;
        			for (int[] arr : list) {
        				map[arr[0]][arr[1]] = sum / list.size();
        			}
        		}
        	}
        	if (!flag) break;
        	ans++;
        }
        System.out.println(ans);
     }

	static void dfs(int r, int c) {
		if (visited[r][c]) return;
		visited[r][c] = true;
		sum += map[r][c];
		list.add(new int[] {r,c});
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (valid(nr, nc)) if (between(Math.abs(map[r][c] - map[nr][nc]))) dfs(nr, nc);
		}
	}
	
	static boolean between(int a) {
		if (a >= rs && a <= re) return true;
		return false;
	}
	
	static boolean valid(int r, int c) {
		if (r >= 0 && r < n && c >= 0 && c < n && !visited[r][c]) return true;
		return false;
	}
	
}