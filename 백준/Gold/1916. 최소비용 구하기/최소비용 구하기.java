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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 도시 개수
		int m = Integer.parseInt(br.readLine()); // 도로 개수
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		ArrayList<Node>[] map = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) map[i] = new ArrayList<Node>();
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[start].add(new Node(end,d));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
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
		System.out.println(dist[end]);
	}
}