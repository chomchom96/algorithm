import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	
	static StringTokenizer st;
	static int n;
	static List<Integer>[] graph;
	static int[] size;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	int q = Integer.parseInt(st.nextToken());
    	
    	graph = new ArrayList[n+1];
    	for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
    	for (int i = 0; i < n - 1; i++) {
    		st = new StringTokenizer(br.readLine());
    		int s = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		graph[s].add(e); graph[e].add(s);
    	}
    	size = new int[n+1];
    	dfs(r, 0);
    	
//    	System.out.println(Arrays.toString(size));
    	
    	while (q --> 0) System.out.println(size[Integer.parseInt(br.readLine())]);

	}

	private static void dfs(int child, int parent) {
		size[child] = 1;
		for (int next : graph[child]) {
			if (next == parent) continue;
			dfs(next, child);
			size[child] += size[next];
		}
		
	}
}