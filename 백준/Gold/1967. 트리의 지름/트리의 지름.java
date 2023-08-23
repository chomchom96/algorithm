import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int result = 0;
    static int max_node = 0;
    static ArrayList<Edge>[] nodes;

    static class Edge{ // 트리(그래프) 저장용
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node{
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); 
        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }
        nodes = new ArrayList[n + 1]; 
        for (int i = 1; i <= n; i++) { 
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]); 
            int end = Integer.parseInt(inputs[1]); 
            int weight = Integer.parseInt(inputs[2]); 

            nodes[start].add(new Edge(end, weight));
            nodes[end].add(new Edge(start, weight));
 
        }

        bfs(1);
        if (n > 2) bfs(max_node); 

        System.out.println(result);
    }


    public static void bfs(int start) {

        boolean[] visited = new boolean[n + 1];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;

        int max_cnt = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if(now.cnt > max_cnt){
                max_cnt = now.cnt;	// 가장 멀리 떨어진 노드의 거리
                max_node = now.idx;	// 가장 멀리 떨어진 노드의 번호
            }

            for (Edge e : nodes[now.idx]) {
                if(!visited[e.end]){
                    visited[e.end] = true;
                    q.add(new Node(e.end, now.cnt + e.weight));
                }
            }
        }

        result = Math.max(result, max_cnt);

    }
}