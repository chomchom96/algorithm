import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static boolean[][] visited;
	static int[][] map;
	static int[][] size;

	static final int INF = 125000;
	static int N, cr, cc;

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int val;

		public Node(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

		public int compareTo(Node o) {
			return val - o.val;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder(); 
		int tc = 1;

		String input = "";
		while(!(input = br.readLine()).isEmpty()  ) {
			N = Integer.parseInt(input);
			if(N == 0) break;
			
			map = new int[N][N];
			visited = new boolean[N][N];
			size = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());	
					size[i][j] = INF;
				}
			}

			dijikstra(0, 0, map[0][0]);
			sb.append("Problem " + tc + ": " + size[N-1][N-1]).append('\n');
			tc++;
		}

		System.out.println(sb);

	} 

	static void dijikstra(int r, int c, int val) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		visited[r][c] = true;
		queue.offer(new Node(r, c, val));

		while( !queue.isEmpty() ) {
			Node cur = queue.poll();
			for(int i = 0; i < 4; i++) {
				int cr = cur.r + dr[i];
				int cc = cur.c + dc[i];

				if(valid(cr, cc) && size[cr][cc] > (map[cr][cc] + cur.val)) {
					size[cr][cc] = map[cr][cc] + cur.val;
					visited[cr][cc] = true;
					queue.offer( new Node( cr, cc, size[cr][cc] ));
				}

			}
		}

	} 

	static boolean valid(int r, int c) {
		if (r >= 0 && c >= 0 && r < N && c < N) if (!visited[r][c]) return true;
		return false;
	} 

}