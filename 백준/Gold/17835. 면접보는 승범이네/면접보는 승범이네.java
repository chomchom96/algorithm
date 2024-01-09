import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge>{

        private int to;
        private long dist;

        public Edge(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(dist, o.dist);
        }
    }

    static int n,m;
    static ArrayList<Edge>[] map;
    static Queue<Integer> queue = new LinkedList<Integer>();
    static Long[] totalDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) map[i] = new ArrayList<Edge>();
        totalDist = new Long[n+1];
        Arrays.fill(totalDist, Long.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[v].add(new Edge(u,c));
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        dijikstra();

        Long maxDist = 0L;
        int maxNode = 0;

        for (int i = n; i >= 1; i--) {
            if (maxDist <= totalDist[i]) {
                maxNode = i;
                maxDist = totalDist[i];
            }
        }

        System.out.println(maxNode);
        System.out.println(maxDist);

    }

    private static void dijikstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Long[] dist = new Long[n+1];
        Arrays.fill(dist, -1L);

        for (int start : queue) {
            dist[start] = 0L;
            pq.offer(new Edge(start, 0));
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (dist[cur.to] == -1 || dist[cur.to] < cur.dist) continue;
            for (Edge next: map[cur.to]) {
                if (dist[next.to] == -1 || dist[next.to] > dist[cur.to] + next.dist) {
                    dist[next.to] = dist[cur.to] + next.dist;
                    pq.offer(new Edge(next.to, dist[next.to]));

                }

            }
        }

        for (int i = 1; i <= n; i++) {
            totalDist[i] = Math.min(totalDist[i], dist[i]);
        }

    }
}