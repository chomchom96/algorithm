import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n, m, k;
	static StringTokenizer st;
	static int ans = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] cmd;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		cmd = new int[k][3];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			cmd[i][0] = Integer.parseInt(st.nextToken()); cmd[i][1] = Integer.parseInt(st.nextToken()); cmd[i][2] = Integer.parseInt(st.nextToken()); 
		}
		visited = new boolean[k];
		backTrack(0, board);
		System.out.println(ans);
		
	
	}
	
	static void backTrack(int depth, int[][] board) {
		
		if (depth == k) {
			ans = Math.min(calculateMin(board), ans);
			return;
		}
		for (int i = 0; i < k; i++) {
			if (!visited[i]) {
				int[] command = cmd[i];
				int[][] nboard = rotate(command[0]-1, command[1]-1, command[2], board);
				visited[i] = true;
				backTrack(depth + 1, nboard);
				visited[i] = false;
			}
		}
	}
	
	
	
	static int[][] rotate(int r, int c, int rad, int[][] board){ // board row : n, col : c, (r,c) 기준으로 반경 rad만큼 rotate
		int[][] cBoard = copyMap(board); // copy 메소드도 만들기 ! 
		
		for (int i = -rad; i <= rad; i++) {
			for (int j = -rad; j <= rad; j++) {
				if (i <= j) {
					if (i * -1 >= j) { // 1번
						if (i * -1 == j) cBoard[r+i+1][c+j] = board[r+i][c+j];
						else cBoard[r+i][c+j+1] = board[r+i][c+j];						
					}
					else {
						if (i == j) cBoard[r+i][c+j-1] = board[r+i][c+j];
						else cBoard[r+i+1][c+j] = board[r+i][c+j];
					}
				}
				else {
					if (i >= j * -1) {
						if (i == j * -1) cBoard[r+i-1][c+j] = board[r+i][c+j];
						else cBoard[r+i][c+j-1] = board[r+i][c+j];
					}
					else cBoard[r+i-1][c+j] = board[r+i][c+j];
				}
			}
		}

		return cBoard;
	}
	
	static int[][] copyMap(int[][] board) {
		int[][] copy = new int[board.length][board[0].length];
		for (int i = 0; i < n; i++) for(int j = 0; j < m; j++) copy[i][j] = board[i][j];
		return copy;
	}
	
	static int calculateMin(int[][] board) {
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < m; j++) sum += board[i][j];
			minSum = Math.min(sum, minSum);
		}
		return minSum;
	}
}
