import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        int[] cur = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 9) {
                    cur = new int[]{i, j};
                    board[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0; 
        int move = 0;

        while (true) {
            Queue<int[]> queue = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[N][N];

            queue.add(new int[]{cur[0], cur[1], 0}); 
            visit[cur[0]][cur[1]] = true;

            boolean flag = false; 

            while (!queue.isEmpty()) {
                cur = queue.poll();

                if (board[cur[0]][cur[1]] != 0 && board[cur[0]][cur[1]] < size) { 
                    board[cur[0]][cur[1]] = 0; 
                    eat++;
                    move += cur[2]; 
                    flag = true; 
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || nx < 0 || nx >= N || ny >= N || visit[ny][nx] || board[ny][nx] > size)
                        continue;

                    queue.add(new int[]{ny, nx, cur[2] + 1});
                    visit[ny][nx] = true;
                }
            }

            if (!flag)
                break;

            if (size == eat) {
                size++;
                eat = 0;
            }
        }

        System.out.println(move);
    }
}
