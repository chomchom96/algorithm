import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int n, dist;
	public Node(int n, int dist) {
		this.n = n;
		this.dist = dist;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return dist - o.dist;
	}
	
}


public class Main {
	static int[] dist;
	static int n,m;
	static ArrayList<Node>[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 도시 개수
		m = Integer.parseInt(st.nextToken()); // 도로 개수
		map = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) map[i] = new ArrayList<Node>();
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[start].add(new Node(end,d));
			map[end].add(new Node(start,d));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int a = dijikstra(1, start);
		int b = dijikstra(end, n);
		int c = dijikstra(1, end);
		int d = dijikstra(start, n);
		int routeA = 0; int routeB = 0;
		routeA = !(a == -1 || b == -1)? a+b : Integer.MAX_VALUE;
		routeB = !(c == -1 || d == -1)? c+d : Integer.MAX_VALUE;
		int dist = dijikstra(start, end);
		int ans = (routeA == Integer.MAX_VALUE && routeB == Integer.MAX_VALUE)? -1: Math.min(routeA, routeB) + dist;
		System.out.println(ans);
	}
	
	static int dijikstra(int start, int end) {
		if (start == end) return 0;
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		dist[start] = 0;
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start,0));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (dist[cur.n] == -1 || dist[cur.n] < cur.dist) continue;
			for (Node next : map[cur.n]) {
				if (dist[next.n] == -1 || dist[next.n] > dist[cur.n] + next.dist) {
					dist[next.n] = dist[cur.n] + next.dist;
					queue.offer(new Node(next.n, dist[next.n]));
				}
			}
		}
		return dist[end];
	}
}