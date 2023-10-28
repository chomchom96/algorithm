import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new char[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) map[i][j] = line.charAt(j);
        }
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) if (!visited[i][j]) {
            if (map[i][j] == '-') dfs(i, j, true);
            else dfs(i, j, false);
            cnt++;
        }
        System.out.println(cnt);

    }

    private static void dfs(int i, int j, boolean isGaro) {
        visited[i][j] = true;
        if (isGaro) {
            if (j < m - 1 && map[i][j+1] == '-') dfs(i, j+1, true);
        }
        else {
            if (i < n - 1 && map[i+1][j] == '|') dfs(i+1, j, false);
        }
    }
}