import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dice; // 주사위 전개도, (x = 1, y = 1)이 윗면, (x = 1, y = 3)이 아랫면 
	static int[] dx = { 0, 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int y = Integer.parseInt(st1.nextToken()); // 입력값 x가 y 좌표인 것 주의
		int x = Integer.parseInt(st1.nextToken()); // 입력값 y가 x 좌표인 것 주의
		int K = Integer.parseInt(st1.nextToken());
		int[][] map = new int[N][M];
		dice = new int[4][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		int[] command = new int[K];
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {
			command[i] = Integer.parseInt(st3.nextToken());
		}
		
		for (int i = 0; i < K; i++) {
			int nx = x + dx[command[i]];
			int ny = y + dy[command[i]];
			
			if (nx < 0 || ny < 0 || nx >= M || ny >= N) { // 범위를 벗어나는 경우 해당 명령 무시
				continue;
			}
			
			// 이동 방향에 따른 처리
			if (command[i] == 1) {
				moveR();
			} else if (command[i] == 2) {
				moveL();
			} else if (command[i] == 3) {
				moveU();
			} else {
				moveD();
			}
			
			if (map[ny][nx] == 0) { // 현재 위치의 지도가 0인 경우
				map[ny][nx] = dice[3][1]; // 주사위의 밑면의 숫자를 지도에 복사
			} else if (map[ny][nx] != 0) { // 현재 위치의 지도가 0이 아닌 경우
				dice[3][1] = map[ny][nx]; // 주사위의 밑면에 지도의 숫자 복사
				map[ny][nx] = 0; // 지도의 숫자 0으로 변경
			}
			
			x = nx; // 이동한 x좌표 갱신
			y = ny; // 이동한 y좌표 갱신
			
			System.out.println(dice[1][1]);
		}
	}
	
	// 왼쪽으로 굴리기
	public static void moveL() {
		int temp = dice[1][1];
		dice[1][1] = dice[1][2];
		dice[1][2] = dice[3][1];
		dice[3][1] = dice[1][0];
		dice[1][0] = temp;
	}
	
	// 오른쪽으로 굴리기
	public static void moveR() {
		int temp = dice[1][1];
		dice[1][1] = dice[1][0];
		dice[1][0] = dice[3][1];
		dice[3][1] = dice[1][2];
		dice[1][2] = temp;
	}
	
	// 위쪽으로 굴리기
	public static void moveU() {
		int temp = dice[1][1];
		dice[1][1] = dice[2][1];
		dice[2][1] = dice[3][1];
		dice[3][1] = dice[0][1];
		dice[0][1] = temp;
	}
	
	// 아래쪽으로 굴리기
	public static void moveD() {
		int temp = dice[1][1];
		dice[1][1] = dice[0][1];
		dice[0][1] = dice[3][1];
		dice[3][1] = dice[2][1];
		dice[2][1] = temp;
	}
}