import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, C;
    static int[][] coords;
    static int[] parent;
    static class Edge implements Comparable<Edge> {
        private int start, end;
        private long dist;
        public Edge(int start, int end, long dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }


        @Override
        public int compareTo(Edge o) {
            return Long.compare(dist, o.dist);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        coords = new int[N+1][2];
        for (int i = 1 ; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            coords[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 1; i < N; i++) {
            int sx = coords[i][0];
            int sy = coords[i][1];
            for (int j = i + 1; j <= N; j++) {
                int ex = coords[j][0];
                int ey = coords[j][1];
                long dist = (sx - ex) * (sx - ex) + (sy - ey) * (sy - ey);
                if (dist >= C) pq.offer(new Edge(i, j, dist));
            }
        }
        int cnt = 0;
        long distSum = 0L;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int start = cur.start;
            int end = cur.end;
            long dist = cur.dist;
            if (!union(start, end)) {
                cnt++;
                distSum += dist;
            }
            if (cnt==N-1) break;
        }
        System.out.println(cnt!=N-1? -1: distSum);

    }

    static int find(int a) {
        if (parent[a] != a) return parent[a] = find(parent[a]);
        return a;
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;
        else {
            parent[a] = b;
            return false;
        }

    }

}