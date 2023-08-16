import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int node, edge;
    static List<List<Integer>> I = new ArrayList<>();
    static int[] count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        count = new int[node + 1];
        visited = new boolean[node + 1];
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
            System.out.println(count[i]);
        }
    }

    static void dfsStack(int start) {
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        stack.push(start);

        while (!stack.isEmpty()) {
            int curNode = stack.pop();
            if (!visited[curNode]) count[curNode] = num++;
            visited[curNode] = true;

            for (int i = 0; i <  I.get(curNode).size(); i++) {
                int nextNode = I.get(curNode).get(i);
                if (!visited[nextNode]) {
                	stack.push(nextNode);
                }
            }
        }
    }
}