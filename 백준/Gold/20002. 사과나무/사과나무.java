import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) calc(i, j);
        System.out.println(ans);

    }

    private static void calc(int r, int c) {
        int range = Math.min(N-r, N-c);
        int sum = 0;
        for (int i = 0; i < range; i++) {
            sum += map[r+i][c+i];
            for (int j = 1; j <= i; j++) {
                sum += map[r+i-j][c+i];
                sum += map[r+i][c+i-j];
            }
            ans = Math.max(ans, sum);
        }
    }

}
