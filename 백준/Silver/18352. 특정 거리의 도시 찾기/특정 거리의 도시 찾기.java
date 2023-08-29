import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class ND implements Comparable<ND>{
	int n, d;
	
	public ND(int n, int d) {
		super();
		this.n = n;
		this.d = d;
	}
	
	@Override
	public int compareTo(ND o) {
		// TODO Auto-generated method stub
		return d - o.d;
	}
	
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()); 
		int n = Integer.parseInt(st.nextToken()); // 도시 개수
		int m = Integer.parseInt(st.nextToken()); // 도로 개수
		int k = Integer.parseInt(st.nextToken()); // 찾는 거리 : 출발 도시에서 거리가 정확히 k인 경우
		int x = Integer.parseInt(st.nextToken()); // 출발 도시
		
		int[] dist = new int[n+1];
		Arrays.fill(dist, -1);
		dist[x] = 0;
		
		List<ND>[] list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) list[i] = new ArrayList<ND>();
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(new ND(end, 1));
		}
		
		Queue<ND> queue = new PriorityQueue<>();
		queue.add(new ND(x, 0)); // 시작 도시
		// dijikstra
		while (!queue.isEmpty()) {
			ND cur = queue.poll();
			if (dist[cur.n] != -1 && cur.d > dist[cur.n]) {
				continue;
			}
			for (ND next : list[cur.n]) {
				if (dist[next.n] == -1 || dist[next.n] > dist[cur.n] + next.d) {
					dist[next.n] = dist[cur.n] + next.d;
					queue.offer(new ND(next.n, dist[next.n]));
				}
			}
		}
		boolean found = false;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == k) {
				found = true; System.out.println(i);
			}
		}
		if (!found) System.out.println(-1);

	}
}