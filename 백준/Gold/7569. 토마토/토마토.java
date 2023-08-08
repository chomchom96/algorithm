import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M, N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); 
        int[][] graph = new int[N*K][M];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < N * K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int[] dx = {1, 0, -1, 0, N, -N};
            int[] dy = {0, 1, 0, -1, 0, 0};
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N * K && 0 <= ny && ny < M && graph[nx][ny] == 0) {
                	if (i == 2 & (nx % N == N-1)) continue;
                    if (i == 0 & (nx % N == 0)) continue;
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        int answer = findMax(graph) - 1;

        for (int i = 0; i < N * K; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) answer = -1;
            }
        }
        System.out.println(answer);
    }

    static int findMax(int[][] graph) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                max = Math.max(max, graph[i][j]);
            }
        }
        return max;
    }
}