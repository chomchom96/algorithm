import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	String noise = br.readLine();
    	
    	int term = 1;
    	int min = Integer.MAX_VALUE;
    	while (term <= n) {
    		int cnt = 0;
    		boolean[] visited = new boolean[n];
    		for (int i = 0; i < n; i++) {
    			if (noise.charAt(i) == '#' && !visited[i]) {
    				cnt++;
    				int c = i;
    				while (true) {
    					if (c >= n) break;
    					if (noise.charAt(c) == '#') {
    						visited[c] = true; c += term;
    					}
    					else break;
    				}
    			}
    		}
    		min = Math.min(min, cnt);
    		term++;
    	}
    	System.out.println(min);
    }
}