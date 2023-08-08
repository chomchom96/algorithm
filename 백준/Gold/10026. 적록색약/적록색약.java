import java.io.*;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] v, cv;
	static int N, count, ccount;
	static char[][] graph, graph2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new char[N][N]; 
		graph2 = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char col = str.charAt(j);
				graph[i][j] = col;
				
				if (col == 'G') graph2[i][j] = 'R'; 
				else graph2[i][j] = col;
			}
		}

		// 초기화
		v = new boolean[N][N]; count = 0;
		cv = new boolean[N][N]; ccount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					dfs(i, j, v, graph, graph[i][j]);
					count++;
				}
				if (!cv[i][j]) {
					dfs(i, j, cv, graph2, graph2[i][j]);
					ccount++;
				}
			}
		}
		System.out.println(count + " " + ccount);
	}

	static void dfs(int r, int c, boolean[][] visit, char[][] area, char color) {
		visit[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (0 <= nr && nr < N && 0 <= nc && nc < N && !visit[nr][nc] && area[nr][nc] == color) {
				dfs(nr, nc, visit, area, color);
			}
		}
	}
}