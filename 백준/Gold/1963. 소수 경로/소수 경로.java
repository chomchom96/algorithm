import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static Set<Integer> sieve = new HashSet();
	
	
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
		boolean[] isNotPrime = new boolean[10001];
		for (int i = 2; i <= 100; i++) if (!isNotPrime[i]) for (int j = 2; j <= 10000/i; j++) isNotPrime[i*j] = true;
		for (int i = 1001; i < 10000; i++) if (!isNotPrime[i]) sieve.add(i);
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
			if (visited[num]) continue;
			visited[num] = true;
			String nStr = String.valueOf(num);
			for (int i = 0; i < 4; i++) {
				for (int digit = 0; digit < 10; digit++) {
					if (i == 0 && digit == 0) continue;
					 int next = num - (nStr.charAt(i) - '0') * (int) Math.pow(10, 3 - i) + digit * (int) Math.pow(10, 3 - i);
					 if (sieve.contains(next) && !visited[next] && next > 1000) queue.offer(new int[] {next, cnt+1});

				}
			}
		}
		
		System.out.println("Impossible");
	}

}