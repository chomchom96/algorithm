import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
	
	static StringTokenizer st;
	static int n;
	static boolean[] visited;
	static int[][] gods;
	
	static class Edge implements Comparable<Edge>{
		int to;
		double dist;
		
		public Edge(int to, double dist) {
			super();
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return dist > o.dist ? 1 : -1;
		}
		
		
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	gods = new int[n+1][2];
    	double[][] dist = new double[n+1][n+1];
    	for (int i = 1; i <= n; i++) Arrays.fill(dist[i], -1);
    	
    	for (int i = 1; i <= n; i++) {
    		st = new StringTokenizer(br.readLine());
    		int r = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		gods[i] = new int[] {r,c};
    	}
    	
    	while (m --> 0) {
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		dist[start][end] = dist[end][start] = 0;
    	}
    	
    	for (int i = 1; i <= n; i++) {
    		for (int j = 1; j <= n; j++) if (j != i && dist[i][j] != 0) {
    			dist[i][j] = dist[j][i] = getDist(i, j);
    		}
    	}
    	
    	PriorityQueue<Edge> queue = new PriorityQueue<>();
    	visited = new boolean[n + 1];
    	visited[1] = true;
    	double sum = 0;
    	for (int j = 2; j <= n; j++) queue.offer(new Edge(j, dist[1][j]));
    	while (!allVisit()) {
    		Edge cur = queue.poll();
    		if (!visited[cur.to]) {
    			visited[cur.to]= true;
    			sum += cur.dist;
    			for (int i = 1; i <= n; i++) if (!visited[i]) queue.offer(new Edge(i, dist[cur.to][i])); 
    		}
    	}
    	System.out.println(String.format("%.2f", sum));
    	
	}

    static double getDist(int i, int j) {
    	double sum = 0;
    	sum += Math.pow(gods[i][0] - gods[j][0], 2) + Math.pow(gods[i][1] - gods[j][1], 2);
    	return Math.sqrt(sum);
    }
    
    
	static boolean allVisit() {
		for (int i = 1; i <= n; i++) if (!visited[i]) return false;
		return true;
	}
}