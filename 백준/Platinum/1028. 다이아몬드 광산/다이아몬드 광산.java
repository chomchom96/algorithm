import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int max = 755;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] arr = new int[max][max];
        int[][] rightDown = new int[max][max];
        int[][] leftDown = new int[max][max];

        for (int i = 1; i <= R; i++) {
            String row = br.readLine();
            for (int j = 1; j <= C; j++) {
                char x = row.charAt(j - 1);
                arr[i][j] = (x == '1' ? 1 : 0);
            }
        }

        for (int i = R; i >= 1; i--) {
            for (int j = C; j >= 1; j--) {
                if (arr[i][j] == 0)
                    continue;
                rightDown[i][j] = rightDown[i + 1][j + 1] + arr[i][j];
            }
        }

        for (int i = R; i >= 1; i--) {
            for (int j = C; j >= 1; j--) {
                if (arr[i][j] == 0)
                    continue;
                leftDown[i][j] = leftDown[i + 1][j - 1] + arr[i][j];
            }
        }

        int ans = 0;
        for (int len = 375; len >= 0; len--) {
            for (int i = 1; i <= R; i++) {
                if (i + 2 * len - 2 <= R) {
                    for (int j = 1; j <= C; j++) {
                        if (j - len + 1 >= 1 && j + len - 1 <= C) {
                            if (rightDown[i][j] >= len && leftDown[i + len - 1][j + len - 1] >= len && leftDown[i][j] >= len && rightDown[i + len - 1][j - len + 1] >= len) {
                                System.out.println(len);
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
