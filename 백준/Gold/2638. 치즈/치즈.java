import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	final static int[] dx = { 1, 0, -1, 0,};
    final static int[] dy = { 0, 1, 0, -1 };
	static int N, M;
	static int[][] cheese;
	static boolean[][] visited;
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N][M];

        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };
        int time = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        while (true) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {0, 0});
            visited = new boolean[N][M];
            visited[0][0] = true;
            List<int[]> melt = new ArrayList<>();
            int[][] cnt = new int[N][M];

            boolean end = true;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dx[d];
                    int nc = cur[1] + dy[d];

                    if (isValid(nr,nc)) {
                    	if (cheese[nc][nr] == 0) {
                            queue.add(new int[] { nr, nc });
                            visited[nc][nr] = true;
                        } 
                    	else {
                            end = false;
                            if (++cnt[nc][nr] == 2) 
                                melt.add(new int[] { nr, nc });
                        }
                    }
                }
            }

            for (int[] n : melt) cheese[n[1]][n[0]] = 0;

            if (end)
                break;

            time++;
        }

        System.out.println(time);
    }
    
    static boolean isValid(int r, int c) {
    	if (r < 0 || c < 0 || r >= M || c >= N) return false;
    	else if (visited[c][r]) return false;
    	return true;
    }
}