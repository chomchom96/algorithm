import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        while (E-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            queue.add(new int[] { from, to, value });
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        int ans = 0;

        while (!queue.isEmpty() && !isUnion()) {
            int[] cur = queue.poll();
            int from = cur[0];
            int to = cur[1];
            int value = cur[2];
            if (union(from, to))
                ans += value;
        }

        System.out.println(ans);
    }

    static boolean isUnion() {
        int p1 = parent[1];
        for (int i = 1; i <= N; i++) {
            if (parent[i] != p1)
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
        if (parent[a] != a) {
            return parent[a] = find(parent[a]);
        }
        return a;
    }
}
