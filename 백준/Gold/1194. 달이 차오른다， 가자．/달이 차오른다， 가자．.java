import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static class Node {
        int r;
        int c;
        int count;
        int key;

        public Node(int x, int y, int count, int key) {
            this.r = x;
            this.c = y;
            this.count = count;
            this.key = key;
        }
    }
	
	static int n, m;
    static char[][] map;
    static boolean[][][] visited;
    static Node start;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][64];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    start = new Node(i, j, 0, 0);
                }
            }
        }

        bfs(start.r, start.c);
    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(x, y, 0, 0));
        
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int count = cur.count;
            int key = cur.key;

            if (map[cur.r][cur.c] == '1') {
                System.out.println(cur.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if (map[nr][nc] == '#' || visited[nr][nc][key]) {
                    continue;
                }

                if (map[nr][nc] - 'a' >= 0 && map[nr][nc] - 'a' < 6) {
                    int tempKey = (1 << (map[nr][nc] - 'a')) | key;

                    if (!visited[nr][nc][tempKey]) {
                        visited[nr][nc][tempKey] = true;
                        visited[nr][nc][key] = true;
                        queue.add(new Node(nr, nc, count + 1, tempKey));
                    }
                } else if (map[nr][nc] - 'A' >= 0 && map[nr][nc] - 'A' < 6) {
                    int tempDoor = (1 << (map[nr][nc] - 'A')) & key;

                    if (tempDoor > 0) {
                        visited[nr][nc][key] = true;
                        queue.add(new Node(nr, nc, count + 1, key));
                    }
                } else {
                    visited[nr][nc][key] = true;
                    queue.add(new Node(nr, nc, count + 1, key));
                }
            }
        }

        System.out.println(-1);
    }

}