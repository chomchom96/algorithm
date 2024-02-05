import java.util.*;
import java.io.*;

public class Main {

    static boolean visited[], isCycle;
    static int N, distance[];
    static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, -1);

        ArrayList<Integer> adj[] = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        DFS(adj, 0, 1);
        BFS(adj);

        for (int i = 1; i <= N; i++) {
            sb.append(distance[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void BFS(ArrayList<Integer>[] adj) {
        int cnt = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                int tmp = queue.poll();
                for (int i : adj[tmp]) {
                    if (distance[i] != -1) continue;
                    distance[i] = cnt;
                    queue.add(i);
                }
            }
            cnt++;
        }
    }

    private static void DFS(ArrayList<Integer>[] adj, int prev, int curr) {
        visited[curr] = true;
        for (int next : adj[curr]) {
            if (visited[next] && next != prev) {
                isCycle = true;
                distance[next] = 0;
                queue.add(next);
                break;
            } else if (!visited[next]) {
                DFS(adj, curr, next);
                if (isCycle) {
                    if (distance[next] == 0) {
                        isCycle = false;
                    } else {
                        distance[next] = 0;
                        queue.add(next);
                    }
                    return;
                }
            }
        }
    }
}