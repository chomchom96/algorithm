import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 50005;

    static int N, M;
    static Set<Integer>[] adj = new HashSet[MAX];
    static int[] R = new int[MAX];

    static int find(int x) {
        if (R[x] < 0) return x;
        return R[x] = find(R[x]);
    }

    static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) R[xRoot] = yRoot;
    }

    static Set<Integer> arr = new HashSet<>();
    static int[] indegree = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Arrays.fill(R, -1);

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N ; i++) adj[i] = new HashSet<>();
        List<int[]> V = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char c = st.nextToken().toCharArray()[0];
            int b = Integer.parseInt(st.nextToken());
            if (c == '=') union(a, b);
            else V.add(new int[]{a, b});
        }

        for (int[] relation : V) {
            int a = relation[0];
            int b = relation[1];
            a = find(a);
            b = find(b);
            arr.add(a);
            arr.add(b);
            if (!adj[b].contains(a)) {
                indegree[a]++;
                adj[b].add(a);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int root : arr) {
            if (indegree[root] == 0) queue.add(root);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            cnt++;
            for (int neighbor : adj[curr]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.add(neighbor);
            }
        }

        if (cnt == arr.size()) System.out.println("consistent");
        else System.out.println("inconsistent");
    }
}
