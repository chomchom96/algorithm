import java.io.*;
import java.util.*;

public class Main {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] board;
    static int n, m;
    static int cheese;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        cheese = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) cheese++;
            }
        }

        int ans = 0;
        int time = 0;
        while(cheese != 0) {
            ans = cheese;
            time++;
            visited = new boolean[n][m];
            bfs();
        }
        System.out.println(time);
        System.out.println(ans);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if(board[nr][nc] == 0) {
                        queue.offer(new int[] {nr, nc});
                    } else {
                        cheese--;
                        board[nr][nc] = 0;
                    }
                }
            }
        }
    }
}