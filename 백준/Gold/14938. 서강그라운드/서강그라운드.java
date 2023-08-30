import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	int n,d; // n for num, d for dist
	public Node(int n, int d) {
		this.n = n;
		this.d = d;
	}
	@Override
	public int compareTo(Node o) {
		return d - o.d;
	}
	
}

public class Main {
	static int n, range;
	static int[] value;
	static List<Node>[] map;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		int route = Integer.parseInt(st.nextToken());
		value = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) value[i] = Integer.parseInt(st.nextToken());
		map = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) map[i] = new ArrayList<Node>();
		while (route --> 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			map[start].add(new Node(end,dist));
			map[end].add(new Node(start,dist));
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) ans = Math.max(ans, dijikstra(i));
		System.out.println(ans);
	}
	
	static int dijikstra(int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		dist[start] = 0;
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (dist[cur.n] == -1 || dist[cur.n] < cur.d) continue;
			for (Node next : map[cur.n]) {
				if (dist[next.n] == -1 || dist[next.n] > dist[cur.n] + next.d) {
					dist[next.n] = dist[cur.n] + next.d;
					queue.offer(new Node(next.n, dist[next.n]));
				}
			}
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] != -1 && dist[i] <= range) cnt += value[i];
		}
		return cnt;
	}
}