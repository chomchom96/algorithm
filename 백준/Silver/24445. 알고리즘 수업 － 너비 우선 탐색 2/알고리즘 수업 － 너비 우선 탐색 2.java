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
            I.add(new ArrayList<>()); // 이차원 리스트, 그래프 표현
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            I.get(A).add(B);
            I.get(B).add(A); // graph에 (A,B), (B,A) 추가
        }

        for (int i = 1; i <= node; i++) {
            Collections.sort(I.get(i), Collections.reverseOrder()); // 문제에서 노드 내림차순
        }

        bfs(start);
        
        for (int i = 1; i <= node; i++){
            System.out.println(visited[i]);
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 1;

        queue.offer(start);
        visited[start] = cnt++;

        while(!queue.isEmpty()) {
            int curNode = queue.poll();

            for (int i = 0; i < I.get(curNode).size(); i++) {
                int nextNode = I.get(curNode).get(i);

                if (visited[nextNode] != 0) {
                    continue;
                }

                queue.offer(nextNode);
                visited[nextNode] = cnt++;
            }
        }
    }
}