import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int range = Integer.parseInt(st.nextToken());
		int route = Integer.parseInt(st.nextToken());
		
		int[] value = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) value[i] = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n+1][n+1];
		while (route --> 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			map[start][end] = map[end][start] = dist;
		}
		// map 초기화
		for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) if (map[i][j] == 0 && i != j) map[i][j] = 100000;
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) map[i][j] = map[i][k] + map[k][j];
				}
			}
		}
		
		int max = 0;
		
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (map[i][j] <= range) sum += value[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
		
	}
}