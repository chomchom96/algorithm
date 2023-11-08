import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		
		private int from, to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return cost - o.cost;
		}
		
	}
	
	static int n;
	static List<Edge>[] graph;
	static List<Edge>[] mst;
	static int[][] maxCost;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) graph[i] = new ArrayList<Edge>();

		PriorityQueue<Edge> queue = new PriorityQueue<>();
		parent = new int[n+1];
		for (int i = 1; i <= n; i++) parent[i] = i;
		
		int m = Integer.parseInt(st.nextToken());
		while (m --> 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b,c));
			graph[b].add(new Edge(a,c));
			queue.offer(new Edge(a,b,c));
		}
		
		int cnt = 0;
		int totalCost = 0;
		mst = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) mst[i] = new ArrayList<>();
		while (cnt != n - 1) {
			Edge cur = queue.poll();
			if (!union(cur.from, cur.to)) {
				totalCost += cur.cost; cnt++; mst[cur.from].add(new Edge(cur.to,cur.cost)); mst[cur.to].add(new Edge(cur.from, cur.cost));
			}
		}
		
		int q = Integer.parseInt(br.readLine());
		while (q --> 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(totalCost - bfs(a,b));
		}
		
	}

	private static int bfs(int a, int b) {
		boolean[] visited = new boolean[n+1];
		Queue<Edge> queue = new ArrayDeque<>();
		queue.offer(new Edge(a, 0));
		while (!queue.isEmpty()) {
			Edge cur = queue.poll();
			if (cur.to == b) return cur.cost;
			for (Edge next : mst[cur.to]) {
				if (visited[next.to]) continue;
				visited[next.to] = true;
				queue.offer(new Edge(next.to, Math.max(cur.cost, next.cost)));
			}
		}
		return 0;
	}


	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (a > b) parent[a] = b; 
			else parent[b] = a;
			return false;
		}
		return true;
	}
	
	static int find(int a) {
		if (parent[a] != a) return parent[a] = find(parent[a]);
		return a;
	}

}