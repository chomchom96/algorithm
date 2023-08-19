import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static final int[] dr = {1,0,-1,0};
    static final int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[][][] visited = new int[2][n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); 
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int is_Wall = cur[0];
            int r = cur[1];
            int c = cur[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int break_Wall = is_Wall;
                if (map[nr][nc] == 1) {
                    if (is_Wall == 0) {
                        break_Wall = 1; 
                    } else {
                        continue;
                    }
                }

                if (visited[break_Wall][nr][nc] == 0) {
                    visited[break_Wall][nr][nc] = visited[is_Wall][r][c] + 1;
                    queue.offer(new int[]{break_Wall, nr, nc});
                }
            }
        }

        int nbWall = visited[0][n - 1][m - 1];
        int bWall = visited[1][n - 1][m - 1];

        if (nbWall == 0 && bWall == 0) return -1;
        else if (nbWall == 0) return bWall;
        else if (bWall == 0) return nbWall;
        else return Math.min(nbWall, bWall);
    }
}