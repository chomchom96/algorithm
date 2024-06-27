import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static int[] parent;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Queue<Edge> pq = new PriorityQueue<>();
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(br.readLine());
            pq.offer((new Edge(0, i+1, weight)));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (j > i) {
                    pq.offer(new Edge(i+1, j+1, weight));
                }
            }
        }
        // MST
        int answer = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (!union(cur.start, cur.end)) {
                answer += cur.weight;
            }
        }
        System.out.println(answer);
    }

    static int find(int a) {
        if (parent[a] != a) {
            return a = find(parent[a]);
        }
        return a;
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (parent[a] != parent[b]) {
            parent[a] = parent[b];
            return  false;
        }
        return true;
    }
}