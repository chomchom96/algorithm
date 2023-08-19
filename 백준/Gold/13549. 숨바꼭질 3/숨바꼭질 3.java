import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static final int limit = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
    }

    static void bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[limit];
        queue.add(new int[] {start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = cur[0];
            int cnt = cur[1];
            if (num == end) {
                System.out.println(cnt);
                return;
            }
            int tel = num * 2;
            if (tel < limit && !visited[tel]) {
                visited[tel] = true;
                queue.add(new int[] { tel, cnt });
            }

            for (int i = 0; i < 2; i++) {
                int walk = num + 2*i - 1;
                if (walk >= 0 && walk < limit && !visited[walk]) {
                    visited[walk] = true;
                    queue.add(new int[] {walk, cnt + 1});
                }
            }
        }
    }
}