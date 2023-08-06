import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] room = new int[2][7];
		int count = 0;
		int s, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			room[s][y]++;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 1; j < 7; j++) {
				count += room[i][j] / K;
				if (room[i][j] % K != 0) {
					count++;
				}
			}
		}

		System.out.print(count);

	}
}