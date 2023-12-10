import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int n, dist;
	public Edge(int n, int dist) {
		this.n = n;
		this.dist = dist;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return dist - o.dist;
	}
	
}

public class Main {

	static StringTokenizer st;
	static int n, d, c, cost;
	static ArrayList<Edge>[] graph;
	
    public static void main(String[] args) throws IOException {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	while (T --> 0) {
    		cost = 0;
    		st = new StringTokenizer(br.readLine());
    		n = Integer.parseInt(st.nextToken());
    		d = Integer.parseInt(st.nextToken());
    		c = Integer.parseInt(st.nextToken());
    		graph = new ArrayList[n+1];
    		for (int i = 0; i <= n; i++) graph[i] = new ArrayList<Edge>();
    		
    		for (int i = 0; i < d; i++) {
    			st = new StringTokenizer(br.readLine());
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			int s = Integer.parseInt(st.nextToken());
    			graph[b].add(new Edge(a, s));
    		}
    		
    		dijikstra();
    		
    	}
    }

	private static void dijikstra() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.offer(new Edge(c, 0));
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);	
		dist[c] = 0;
		while (!queue.isEmpty()) {
			Edge cur = queue.poll();
			if (dist[cur.n] == -1 || cur.dist > dist[cur.n]) continue; 
			for (Edge next : graph[cur.n]) {
				if (dist[next.n] == -1 || dist[next.n] > dist[cur.n] + next.dist) {
					dist[next.n] = dist[cur.n] + next.dist;
					queue.offer(new Edge(next.n, dist[next.n]));
				}
			}
		}
		
		int max = -1;
		int cnt = 0;
		for (int i = 1; i <= n; i++) if (dist[i] != -1)  {
			cnt++;
			max = Math.max(max, dist[i]);
		}
		
		System.out.println(cnt + " " + max);
	}
}