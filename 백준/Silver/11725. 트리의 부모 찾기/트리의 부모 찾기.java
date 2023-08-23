import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int node;
	static int root = 1;
	static int[] parent;
	static List<List<Integer>> graph;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        parent = new int[node + 1];
        visited = new boolean[node + 1];
        
        graph = new ArrayList<>();
        int edge = node - 1;
        for (int i = 0; i <= edge + 1; i++) graph.add(new ArrayList<Integer>());
        while (edge --> 0) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	graph.get(start).add(end);
        	graph.get(end).add(start);
        }
        dfs(root);
        for (int i = 2; i <= node; i++) System.out.println(parent[i]);
        
    }
    
    static void dfs(int start) {
    	visited[start] = true;
    	
		List<Integer> edges = graph.get(start);
				
		for (int e : edges) {
			if (!visited[e]) {
				parent[e] = start;
				dfs(e);
			}
		}
    }
}