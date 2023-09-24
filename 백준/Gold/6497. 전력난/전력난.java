import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
	    int from, weight;
	    
	    public Node(int from, int weight) {
	        this.from = from;
	        this.weight = weight;
	    }
	    
	    @Override
	    public int compareTo(Node o) {
	        return weight - o.weight;
	    }
	    
	    @Override
	    public String toString() {
	        return from + " " + weight;
	    }
	}
	// 프림 써봐야지
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
	        st = new StringTokenizer(br.readLine());
	        int m = Integer.parseInt(st.nextToken());
	        int n = Integer.parseInt(st.nextToken());
	        if (m == 0 && n == 0) break;
	        List<Node>[] graph = new ArrayList[m];
	        for (int i = 0; i < m; i++) graph[i] = new ArrayList<Node>();
	        int total = 0;
	        while (n --> 0) {
	        	st = new StringTokenizer(br.readLine());
	        	int from = Integer.parseInt(st.nextToken());
	        	int to = Integer.parseInt(st.nextToken());
	        	int weight = Integer.parseInt(st.nextToken());
	        	total += weight;
	        	graph[from].add(new Node(to, weight));
	        	graph[to].add(new Node(from, weight));
	        }
	        
	        boolean[] visited = new boolean[m];
	        visited[0] = true;
	        int sum = 0;
	        int cnt = 0;
	        PriorityQueue<Node> queue = new PriorityQueue<Node>();
	        for (Node node : graph[0]) queue.offer(node);
	        while (cnt < m - 1) {
	        	Node cur = queue.poll();
	        	if (!visited[cur.from]) {
	        		cnt++;
	        		visited[cur.from] = true;
	        		sum += cur.weight;
	        		for (Node next : graph[cur.from]) queue.offer(next);
	        	}
	        }
	        System.out.println(total - sum);
        }
        
    }
       
}