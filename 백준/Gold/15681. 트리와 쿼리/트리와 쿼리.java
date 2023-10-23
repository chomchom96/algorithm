import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	static StringTokenizer st;
	static int n;
	static List<Integer>[] graph;
	static int[] size;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	int q = Integer.parseInt(st.nextToken());
    	
    	graph = new ArrayList[n+1];
    	visited = new boolean[n+1];
    	for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
    	for (int i = 0; i < n - 1; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		graph[s].add(e); graph[e].add(s);
    	}
    	size = new int[n+1];
    	dfs(r);
    	    	
    	while (q --> 0) System.out.println(size[Integer.parseInt(br.readLine())]);

	}

	private static int dfs(int node) {
		visited[node] = true;
		size[node] = 1;
		for (int next : graph[node]) if (!visited[next]) size[node] += dfs(next);
		return size[node];
	}
}