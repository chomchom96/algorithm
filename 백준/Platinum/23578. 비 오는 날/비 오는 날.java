import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long ans = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();

        Node[] graph = new Node[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            long a = Long.parseLong(st.nextToken());
            graph[i] = new Node(a, 1);
            queue.offer(new Node((graph[i].degree * 2 + 1) * graph[i].num, i));
        }

        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 1; i < n - 1; i++) {
            Node cur = queue.poll();
            graph[(int) cur.degree].degree++;
            queue.offer(new Node((graph[(int) cur.degree].degree * 2 + 1) * graph[(int) cur.degree].num, cur.degree));
        }

        for (int i = 0; i < n; i++) {
//        	System.out.println(graph[i].num + " " + graph[i].degreeo);
            ans += graph[i].num * graph[i].degree * graph[i].degree;
        }

        System.out.println(ans);
    }

    static class Node implements Comparable<Node> {
        long num, degree;

        public Node(long A, long B) {
            this.num = A;
            this.degree = B;
        }

        public int compareTo(Node o) {
        	if (this.num > o.num) return 1;
        	else return -1;
        }
    }
}