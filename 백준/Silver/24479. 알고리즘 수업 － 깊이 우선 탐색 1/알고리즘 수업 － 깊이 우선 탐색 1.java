import java.io.*;
import java.util.*;

public class Main {
    static int node, edge;
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

        dfsStack(start);

        for (int i = 1; i <= node; i++) {
            System.out.println(visited[i]);
        }
    }

    static void dfsStack(int start) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 1;

        stack.push(start);

        while (!stack.isEmpty()) {
            int curNode = stack.pop();

            if (visited[curNode] != 0) {
                continue;
            }

            visited[curNode] = cnt++;

            for (int i = I.get(curNode).size() - 1; i >= 0; i--) {
                int nextNode = I.get(curNode).get(i);
                stack.push(nextNode);
            }
        }
    }
}

