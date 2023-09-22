import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int V;
	static List<Integer>[] graph;
	static int[] group; 
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T --> 0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			graph = new ArrayList[V + 1];
			for (int i = 0; i <= V; i++) graph[i] = new ArrayList<Integer>();
			group = new int[V + 1];
			visited = new boolean[V + 1];
			while (E --> 0) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				graph[A].add(B); graph[B].add(A);
			}
			flag = true;
			for (int i = 1; i <= V; i++) if (!visited[i]) dfs(i, 1);
			System.out.println(flag==true? "YES" : "NO");
		}
	}
	
	static void dfs(int start, int div) {
		group[start] = div;
		visited[start] = true;
		for (int next : graph[start]) {
			if (group[next] == 0) {
				dfs(next, div * (-1));
			}
			if (group[next] == div) {flag= false; return;}
		}
		return;
	}
}