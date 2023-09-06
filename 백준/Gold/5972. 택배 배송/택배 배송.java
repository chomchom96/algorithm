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
	int d;
	int e;
	public Node(int e, int d) {
		this.d = d;
		this.e = e;
	}
	@Override
	public int compareTo(Node o) {
		return d - o.d;
	}
	
}


public class Main {
	static StringTokenizer st;
	static int n;
	static List<Node>[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) map[i] = (new ArrayList<Node>());
		while (m --> 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			map[start].add(new Node(end, dist));
			map[end].add(new Node(start,dist));
		}
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(1,0));
		int[] dist = new int[n + 1];
		Arrays.fill(dist, -1);
		dist[1] = 0;
		while (!queue.isEmpty()){
			Node cur = queue.poll();
			if (dist[cur.e] == -1 || cur.d > dist[cur.e]) continue;
			for (Node next : map[cur.e]) {
				if (dist[next.e] == -1 || next.d + dist[cur.e] < dist[next.e]) {
					dist[next.e] = dist[cur.e] + next.d;
					queue.add(new Node(next.e, dist[next.e]));
				}
			}
		}
		System.out.println(dist[n]);
	}
}