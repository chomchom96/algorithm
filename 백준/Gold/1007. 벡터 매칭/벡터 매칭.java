import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class Main {

	static StringTokenizer st;
	static int N;
	static Point[] Plane;
	static boolean[] visited;
	static double ans;
	
    public static void main(String[] args) throws IOException {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	while (T --> 0) {
    		N = Integer.parseInt(br.readLine());
    		Plane = new Point[N];
    		for (int i = 0; i < N; i++) {
    			st = new StringTokenizer(br.readLine());
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			Plane[i] = new Point(x,y);
    		}
    		ans = 1000000;
        	visited = new boolean[N];
        	comb(0, 0);
        	System.out.println(ans);
    	}
    	
    }

	private static void comb(int depth, int selected) {		
		if (selected == N/2) {
			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					x += Plane[i].x;
					y += Plane[i].y;
				}
				else {
					x -= Plane[i].x;
					y -= Plane[i].y;
				}
 			}
						
			ans = Math.min(ans, Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
			return;
		}
		
		if (depth == N) return;

		visited[depth] = true;
		comb(depth+1, selected+1);
		visited[depth] = false;
		comb(depth+1, selected);
		
	}

}