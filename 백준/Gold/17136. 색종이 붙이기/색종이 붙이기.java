import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int[][] map;
    static int[] paper = { 0, 5, 5, 5, 5, 5 };
    static int ans = Integer.MAX_VALUE;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        backTrack(0, 0, 0);
        
        if (ans > 25) ans = -1;
        System.out.println(ans);
    }
    
    public static void backTrack(int r, int c, int depth) {
        if (r >= 9 && c > 9) {
            ans = Math.min(ans, depth);
            return;
        }
 
        if (c > 9) {
            backTrack(r + 1, 0, depth);
            return;
        }
 
        if (map[r][c] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (paper[i] > 0 && valid(r, c, i)) {
                    attach(r, c, i, 0);
                    paper[i]--;
                    backTrack(r, c + 1, depth + 1);
                    attach(r, c, i, 1);
                    paper[i]++;
                }
            }
        } 
        else backTrack(r, c + 1, depth);
    }
 
    public static void attach(int r, int c, int size, int num) {
        for (int i = r; i < r + size; i++) for (int j = c; j < c + size; j++) map[i][j] = num;
    }

    public static boolean valid(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) return false;
                if (map[i][j] != 1) return false;
            }
        }
        return true;
    }
}