import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int [][] dp;
    static int n;
    static boolean[] visited;
    static List<List<Integer>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph= new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        
        while (m --> 0) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	graph.get(a).add(b);
        	graph.get(b).add(a);
        }
                
        for (int i = 0; i < n; i++) {
        	visited = new boolean[n];
        	dfs(i, 0);
        }
        System.out.println(0);
    }
    static void dfs(int start, int depth) {
    	visited[start] = true;
    	if (depth == 4) {
    		System.out.println(1);
    		System.exit(0);
    	}
    	
    	for (int i : graph.get(start)) {
    		if (!visited[i]) dfs(i, depth + 1);
    	}
    	visited[start] = false;
    	return;
    }
    
}