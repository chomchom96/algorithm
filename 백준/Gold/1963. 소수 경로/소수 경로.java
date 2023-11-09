import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] isNotPrime;
	
	public static void main(String[] args) throws IOException {
		sieve();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		while (T --> 0) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			bfs(a,b);
		}
	
	}

	private static void sieve() {
		isNotPrime = new boolean[10001];
		for (int i = 2; i <= 100; i++) if (!isNotPrime[i]) for (int j = 2; j <= 10000/i; j++) isNotPrime[i*j] = true;
	}

	private static void bfs(String a, String b) {
		int A = Integer.parseInt(a);
		int B = Integer.parseInt(b);
		boolean[] visited = new boolean[10001];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {A, 0});
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int num = cur[0];
			int cnt = cur[1];
			if (num == B) {
				System.out.println(cnt);
				return;
			}
			
			String nStr = String.valueOf(num);
			for (int i = 0; i < 4; i++) {
				for (int digit = 0; digit < 10; digit++) {
					if (i == 0 && digit == 0) continue;
					 int next = num - (nStr.charAt(i) - '0') * (int) Math.pow(10, 3 - i) + digit * (int) Math.pow(10, 3 - i);
					 if (!isNotPrime[next] && !visited[next]) {
						 visited[next] = true; queue.offer(new int[] {next, cnt+1});
					 }
				}
			}
		}
		
		System.out.println("Impossible");
	}

}