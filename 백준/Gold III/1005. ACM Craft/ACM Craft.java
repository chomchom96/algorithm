import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int TC = Integer.parseInt(br.readLine());
		while (TC --> 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] map = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++) map[i] = new ArrayList<Integer>();
			int[] weight = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) weight[i] = Integer.parseInt(st.nextToken()); // 1~n번 weight
			
			int[] inDegree = new int[n + 1]; // 진입 차수 정렬
			while (k --> 0) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				map[start].add(end);
				inDegree[end]++;
			}
			int[] DP = new int[n + 1];
			// 위상 정렬
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= n; i++) if (inDegree[i] == 0) {
				queue.offer(i);
				DP[i] = weight[i];
			}
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				for (int next : map[cur]) {
					inDegree[next]--;
					DP[next] = Math.max(DP[next], DP[cur] + weight[next]);
					if (inDegree[next] == 0) queue.offer(next);
				}
			}
			int dest = Integer.parseInt(br.readLine());
			System.out.println(DP[dest]);
		}
	}
}