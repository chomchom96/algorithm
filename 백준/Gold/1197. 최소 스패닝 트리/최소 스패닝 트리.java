import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int from;
	int to;
	int dist;
	public Node(int from,int to, int dist) {
		this.to = to;
		this.dist = dist;
		this.from = from;
	}
	@Override
	public int compareTo(Node o) {
		return dist - o.dist;
	}
	
}

// Kruskal -> Union-find 할거임
public class Main {
	static int V, E;
	static int[] parent;
	static Queue<Node> queue;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		queue = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			queue.add(new Node(from, to, dist));
		}
		
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) parent[i] = i;
		int sum = 0;

		
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (union(cur.to, cur.from)) sum += cur.dist;
		}
		System.out.println(sum);
	}
	

	static boolean union(int n, int m) {

		n = find(n);
		m = find(m);
		
		if (n == m) return false;
		else {
			
			if (n > m) parent[n] = m;
			else parent[m] = n;
			return true;
		}
	}
	
	static int find(int n) {
		if (parent[n] != n) {
			return parent[n] = find(parent[n]);
		}
		return n;
	}
}
