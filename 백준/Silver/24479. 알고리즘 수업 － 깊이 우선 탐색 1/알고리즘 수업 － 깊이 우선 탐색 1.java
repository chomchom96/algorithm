import java.io.*;
import java.util.*;

public class Main {
    static int node, edge;
    static int cnt = 1;
    static List<List<Integer>> I = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new int[node + 1];
        for (int i = 0; i <= node; i++) {
            I.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            I.get(A).add(B);
            I.get(B).add(A);
        }

        for (int i = 1; i <= node; i++) {
            Collections.sort(I.get(i));
        }

        dfsRecursive(start);

        for (int i = 1; i <= node; i++) {
            System.out.println(visited[i]);
        }
    }

    static void dfsRecursive(int curNode) {
        visited[curNode] = cnt++;

        for (int nextNode : I.get(curNode)) {
            if (visited[nextNode] == 0) {
                dfsRecursive(nextNode);
            }
        }
    }
}
