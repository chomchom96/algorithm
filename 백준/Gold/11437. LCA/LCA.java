import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        depth = new int[N+1];
        depth[1] = 1;
        parent = new int[N+1];

        tree = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) tree[i] = new ArrayList<Integer>();

        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b); tree[b].add(a);
        }

        findDepthWithDFS(1, 1);

        int TC = Integer.parseInt(br.readLine());
        while (TC --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (depth[a] < depth[b]) {
                int temp = b;
                b = a;
                a = temp;
            }
            while (depth[a] != depth[b]) a = parent[a];
            
            while (a != b) {
                a = parent[a];
                b = parent[b];
            }
            System.out.println(a);
        }
    }

    static void findDepthWithDFS(int curNode, int curDepth) {
        for (int nextNode : tree[curNode]) {
            if (depth[nextNode] == 0) {
                depth[nextNode] = curDepth+1;
                parent[nextNode] = curNode;
                findDepthWithDFS(nextNode, curDepth+1);
            }
        }
    }
}
