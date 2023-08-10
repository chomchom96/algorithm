import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < m; i++) {
        	StringTokenizer st2 = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st2.nextToken());
        	int b = Integer.parseInt(st2.nextToken());
        	map[a-1][b-1] = 1;
        	map[b-1][a-1] = 1;
        }
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (map[i][j] == 0 && i!=j) map[i][j] = n;

        for (int k = 0; k < n; k++) {
        	for (int i = 0; i <n; i++) {
        			for (int j = 0; j < n; j++) {
        				if (map[i][j]> map[i][k] + map[k][j]) map[i][j]= map[i][k] + map[k][j];
	    		}
	    	}
	    }
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < n; i++) {
        	int ans = 0;
        	for (int j = 0; j < n; j++) ans += map[i][j];
        	if (ans < min) {
                answer = i; min = ans;
            }
        }
        System.out.println(answer+1);
    } 
}