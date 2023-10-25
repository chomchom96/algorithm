import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int[] value;	
	static int[][] dp;
	static boolean[] visited;
	static List<Integer>[] graph;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		value = new int[N + 1];
		graph = new ArrayList[N+1];
		dp = new int[N + 1][2];
		
		
		for (int i = 1; i <= N; i++) {
			value[i] = Integer.parseInt(st.nextToken()); 
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to); graph[to].add(from);
		}
		visited = new boolean[N + 1];
		dfs(1); 
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
		visited = new boolean[N + 1];
		if (dp[1][0] < dp[1][1]) traverse(1, true);
		else traverse(1, false);
		
		Collections.sort(list);
		for (int i : list) System.out.print(i + " ");
	}
	
	static void traverse(int node, boolean visit) {
		visited[node] = true;
		if (visit) {
			list.add(node);
			for (int next : graph[node]) if (!visited[next]) traverse(next, false);
			
		}
		else{
			for (int next : graph[node]) if (!visited[next]) {
				if (dp[next][1] > dp[next][0]) traverse(next, true);
				else traverse(next, false);
			}
		}
	}

	static void dfs(int node) {
		visited[node] = true;
		for (int next : graph[node]) {
			if (visited[next]) continue;
			dfs(next);
			dp[node][1] += dp[next][0];
			dp[node][0] += Math.max(dp[next][0], dp[next][1]);
			
		}
		dp[node][1] += value[node];
	}
}