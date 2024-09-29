import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int hole = -99;
    static int max = -1;
    static boolean possible = false;
    static int[][] map,dp;
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0, 1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp =  new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<line.length; j++) {
                if(line[j].equals("H")) {
                    map[i][j] = hole;
                }else {
                    int num = Integer.parseInt(line[j]);
                    map[i][j] = num;
                }
            }
        }

        visited[0][0] = true;
        dfs(0,0,1);
        System.out.println(possible? -1: max);
    }

    static void dfs(int x, int y, int cnt) {
        if(cnt>max) {
            max = cnt;
        }
        dp[x][y] = cnt;

        for(int i=0; i<4; i++) {
            int move = map[x][y];
            int nx = x+ (move* dr[i]);
            int ny = y+ (move* dc[i]);

            if(nx<0 || ny<0 || nx>n-1 || ny>m-1 || map[nx][ny] == hole) {
                continue;
            }

            if(visited[nx][ny]) {
                possible = true;
                return;
            }
            if(dp[nx][ny] > cnt) continue;

            visited[nx][ny]= true;
            dfs(nx, ny, cnt+1);
            visited[nx][ny]= false;
        }

    }
}