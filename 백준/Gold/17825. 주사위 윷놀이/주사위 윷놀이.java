import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int score = Integer.MIN_VALUE;
	static final int[][] map = {
            {0, 2, 4, 6, 8, 10},
            {10, 13, 16, 19, 25},
            {10, 12, 14, 16, 18, 20},
            {20, 22, 24, 25},
            {20, 22, 24, 26, 28, 30},
            {30, 28, 27, 26, 25},
            {30, 32, 34, 36, 38, 40},
            {25, 30, 35, 40},
            {40, 0}
    };
	static int diceRoll[] = new int[10];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[][] visited = new boolean[9][];
        for (int i = 0; i < 9; i++) visited[i] = new boolean[map[i].length];
        
        int pos[][] = {{0,0},{0,0},{0,0},{0,0}};
		
		for(int i = 0; i < 10; i++) diceRoll[i] = Integer.parseInt(st.nextToken());

		game(0, pos, 0, visited);
		
		System.out.println(score);
	}
	

	static void game(int idx, int[][] pos, int sum, boolean visited[][]) {
		if(idx == 10) {
			score = Math.max(score, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(pos[i][0] == 8 && pos[i][1] == 1) continue;
			int r = pos[i][0];
			int c = pos[i][1]; 
			int nr = pos[i][0];
			int nc = pos[i][1] + diceRoll[idx];
			
			if(nc == map[nr].length-1) { // 줄 마지막 칸, 지름길 타고 이동
				if(nr < 6 && nr % 2 == 0) { // 6,7이 아닌 경우 0->1, 2->3 ... 
					nr++; nc = 0;
				}
				else if(nr == 6 || nr == 7) {
					nr = 8; nc = 0;
				}
				else if(nr % 2 == 1){ // 지름길에서 도착 줄로
					nr = 7; nc = 0;
				}
				else { // 마지막 줄 : 도착 처리
					nc = 1;
				}
			}
			
			else if(nc >= map[nr].length) { // 줄 넘어가면 지름길 못 탐
				nc = nc - map[nr].length + 1;
				if(nr % 2 == 0) { // 0 -> 2 -> 4 ..
					nr += 2;
					// 도착 처리 
					if (nr >= 8) {
						nr = 8;
						if(nc >= 1) {
							nc = 1;
						}
					}
				}
				else if(nr == 7) {
					nr = 8;
					if(nc >= 1) {
						nc = 1;
					}
				}
				else {
					nr = 7;
					// 넘어가면 도착
					if(nc >= map[nr].length) {
						nr = 8;
						nc = 1;
					}
					// 도착 바로 전 칸
					else if(nc == map[nr].length-1){
						nr = 8;
						nc = 0;
					}
				}	
			}
			// 백트래킹
			if((nr == 8 && nc == 1) || !visited[nr][nc]) {
				visited[r][c] = false;
				visited[nr][nc] = true;
				pos[i][0] = nr;
				pos[i][1] = nc;

				game(idx + 1, pos, sum + map[nr][nc], visited);
				
				visited[nr][nc] = false;
				visited[r][c] = true;
				pos[i][0] = r;
				pos[i][1] = c;
			}
		}
	}
}