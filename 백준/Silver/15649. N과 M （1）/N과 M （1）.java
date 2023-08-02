import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        visited = new boolean[n];
        
        backTrack(0);
        System.out.println(sb);
    }
    
    
    static void backTrack(int depth) {
    	if (depth == m) {
    		for (int a : arr) {
    			sb.append(a).append(' ');
    		}
    		sb.append('\n');
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			arr[depth] = i + 1;
    			backTrack(depth + 1);
    			visited[i] = false;
    		}
    	}
    }
}