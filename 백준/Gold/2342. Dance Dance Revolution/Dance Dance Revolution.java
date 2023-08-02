import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] move;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = st.countTokens();
        move = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            move[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[5][5][n];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(next(0, 0, 0));
    }

    static int next(int left, int right, int cnt) {
        if (cnt == move.length)
            return 0;

        if (dp[left][right][cnt] != -1)
            return dp[left][right][cnt];

        dp[left][right][cnt] = Math.min(next(move[cnt], right, cnt + 1) + dist(left, move[cnt]),
                next(left, move[cnt], cnt + 1) + dist(right, move[cnt]));
        return dp[left][right][cnt];
    }

    static int dist(int from, int to) {

        if (from == 0)
            return 2;
        else if (from == to)
            return 1;
        else if (Math.abs(from - to) % 2 == 1)
            return 3;
        else
            return 4;
    }
}
