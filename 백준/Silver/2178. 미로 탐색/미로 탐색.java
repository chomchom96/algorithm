import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
	static int[][] array;
	final static int[] dx = {1,0,-1,0};
	final static int[] dy = {0,1,0,-1};
	static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        array = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
        	String in = br.readLine();
        	for (int j = 0; j < m; j++) {
        		array[i][j] = in.charAt(j) - '0';
        	}
        }
        
        bfs(0,0);
        System.out.println(array[n-1][m-1]);
    }
    
    static void bfs(int x, int y) {
    	visited[x][y] = true;
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {x,y});
      	while (!queue.isEmpty()) {
    		int[] arr = queue.poll();
	    	for (int i = 0; i < 4; i++) {
	    		int nx = arr[0] + dx[i];
	    		int ny = arr[1] + dy[i];
	    		if (0<=nx&nx<n&0<=ny&ny<m) {
	    			if (array[nx][ny]!=0&!visited[nx][ny]) {
	    				array[nx][ny] = array[arr[0]][arr[1]] + 1;
	    				queue.add(new int[] {nx,ny});
	    				visited[nx][ny] = true;
	    			}
	    		}
	    	}
    	}
    }
}