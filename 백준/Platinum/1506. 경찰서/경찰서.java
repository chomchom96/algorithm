import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, num, total;

    static int[][] graph;

    static int[] order;

    static int[] cost;

    static boolean[] visited;

    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cost[i] = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) graph[i][j] = input.charAt(j) - '0';
        }

        order = new int[N + 1];
        visited = new boolean[N + 1];
        num = 0;
        total = 0;

        for (int i = 0; i < N; i++) if (order[i] == 0) SCC(i);

        System.out.println(total);

    }

    static int SCC(int idx) {
        order[idx] = ++num;
        stack.add(idx);
        int root = order[idx];

        for (int i = 0; i < N; i++) {
            if (graph[idx][i] == 1) {
                if (order[i] == 0) root = Math.min(root, SCC(i));
                else if (!visited[i]) root = Math.min(root, order[i]);
            }
        }

        if (root == order[idx]) {
            int min = cost[idx];
            while (!stack.isEmpty()) {
                int cur = stack.pop();
                min = Math.min(cost[cur], min);
                visited[cur] = true;
                if (cur == idx) break;
            }
            total += min;
        }

        return root;
    }

}
