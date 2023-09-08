import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int[] value;	
	static int[][] dp;
	static List<Integer>[] graph;
	
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

		dfs(1, 0); // 1이 루트 노드임

		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	static void dfs(int child, int parent) {
		for (int next : graph[child]) {
			if (next == parent) continue; // 이미 지나온 노드면 확인할 필요 없음
			dfs(next, child);
			dp[child][1] += dp[next][0];
			dp[child][0] += Math.max(dp[next][0], dp[next][1]);
		}
		dp[child][1] += value[child];
		//dp[child][0] = 0;
	}
}