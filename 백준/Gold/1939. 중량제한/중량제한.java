import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	static int n;
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return o.weight - weight;
		}
		
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        
        Queue<Edge> queue = new PriorityQueue<>();
        while (m --> 0) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	queue.add(new Edge(from, to, weight));
        }
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int ans = 0;
        while (!isUnion(a,b)) {
        	Edge cur = queue.poll();
        	int from = cur.from;
        	int to = cur.to;
        	int weight = cur.weight;
        	union(from, to);
        	ans = weight;
        }
        System.out.println(ans);
    	
    }
    
    static boolean isUnion(int a, int b) {
    	if (find(a) == find(b)) return true;
    	return false;
    }
    
    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if (a != b) parent[a] = b;
    }
    
    static int find(int a) {
    	if (parent[a] != a) return (parent[a] = find(parent[a]));
    	return a;
    }
    
}