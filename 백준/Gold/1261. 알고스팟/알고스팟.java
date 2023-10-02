import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0 ,-1};
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[m][n];
        for (int i = 0; i < m; i++) {
        	String input = br.readLine();
        	for (int j = 0; j < n; j++) graph[i][j] = input.charAt(j) - '0'; 	
        }
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], 10001);
        dist[0][0] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {0,0});
        while (!queue.isEmpty()) {
        	int[] cur = queue.poll();
        	int cr = cur[0], cc = cur[1];
        	for (int i = 0; i < 4; i++) {
        		int nr = cr + dr[i];
        		int nc = cc + dc[i];
        		if (nr >= 0 && nr < m && nc >= 0 && nc < n) if (dist[nr][nc] == 10001 || dist[nr][nc] > dist[cr][cc] + graph[nr][nc]) {
        			dist[nr][nc] = dist[cr][cc] + graph[nr][nc];
        			queue.add(new int[] {nr, nc});
        		}
        	}
        }
        System.out.println(dist[m-1][n-1]);  
    }
}