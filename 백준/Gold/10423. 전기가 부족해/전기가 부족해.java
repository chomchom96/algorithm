import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int from, to, value;

    public Edge(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Edge e) {
        return value - e.value;
    }

}

public class Main {
    static int N;
    static int[] parent;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        st = new StringTokenizer(br.readLine());
        while (K-- > 0)
            parent[Integer.parseInt(st.nextToken())] = -1;

        Queue<Edge> queue = new PriorityQueue<>();
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.add(new Edge(from, to, value));
        }

        int ans = 0;
        while (!queue.isEmpty() && !isUnion()) {
            Edge cur = queue.poll();
            int from = cur.from;
            int to = cur.to;
            int value = cur.value;
            if (union(from, to))
                ans += value;
        }
        System.out.println(ans);
    }

    static boolean isUnion() {
        for (int i = 1; i <= N; i++) {
            if (parent[i] != -1)
                return false;
        }
        return true;
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b)
            return false;
        if (a > b)
            parent[a] = b;
        else
            parent[b] = a;
        return true;
    }

    static int find(int a) {
        if (parent[a] == -1) {
            return -1;
        }

        if (parent[a] != a) {
            return parent[a] = find(parent[a]);
        }
        return a;
    }
}