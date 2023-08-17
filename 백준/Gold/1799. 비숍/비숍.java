import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int board[][];
    static boolean WVisited[][];
    static boolean BVisited[][];
    static int result[];

    static int[] dx = {-1, -1};
    static int[] dy = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        board = new int[n][n];
        WVisited = new boolean[n][n];
        BVisited = new boolean[n][n];
        result = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                BVisited[i][j] = (i+j) % 2 == 0;
            }
        }

        search(-1, true, 0);
        search(-1, false, 0);

        System.out.println(result[0] + result[1]);
    }

    private static void search(int index, boolean isSearchBlack, int count) {
        for (int i = index + 1; i < n * n; i++) {
            int x = i / n;
            int y = i % n;

            if (BVisited[x][y] != isSearchBlack || board[x][y] == 0 || !isValid(x, y)) {
                continue;
            }

            WVisited[x][y] = true;
            search(i, isSearchBlack, count + 1);
            WVisited[x][y] = false;
        }

        int resultIndex = isSearchBlack ? 0 : 1;
        result[resultIndex] = Math.max(result[resultIndex], count);
    }

    private static boolean isValid(int x, int y) {
        // 좌측 하단부터 우측 하단순으로 탐색하므로 윗 대각선의 비숍만 체크한다.
        for (int i = 0; i < 2; i++) {
            int xx = x;
            int yy = y;

            while (true) {
                if (xx >= n || yy >= n || xx < 0 || yy < 0) {
                    break;
                }
                if (WVisited[xx][yy]) {
                    return false;
                }

                xx += dx[i];
                yy += dy[i];
            }
        }

        return true;
    }
}