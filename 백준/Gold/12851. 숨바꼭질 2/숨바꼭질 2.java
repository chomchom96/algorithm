import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static final int limit = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        int cnt = 0;
        if (n == k) {
        	System.out.println(0);
        	System.out.println(1);
        	System.exit(0);
        }
        visited = new boolean[limit];
        
    	Queue<int[]> queue = new LinkedList<>();
    	visited = new boolean[limit];
    	queue.add(new int[] {n, 0});
    	l : while (true) {
    		int[] cur = queue.poll();
    		int num = cur[0];
    		int depth = cur[1];
    		visited[num] = true;
    		if (num == k) {
    			ans = depth;
    			cnt++;
    			while (true) {
    				if (queue.isEmpty()) break l;
    				int[] next = queue.poll();
    				if (next[0] == num && next[1] == depth) cnt++;
    			}
    		}
			if (isValid(num + 1)) queue.offer(new int[] {num + 1, depth + 1});
			if (isValid(num - 1)) queue.offer(new int[] {num - 1, depth + 1});
			if (isValid(num * 2)) queue.offer(new int[] {num * 2, depth + 1});
    		
    		
    	}
    	System.out.println(ans);
    	System.out.println(cnt);    
    }
    
    static boolean isValid(int n) {
    	if (0 > n || n >= limit) return false;
    	if (visited[n]) return false;
    	return true;
    }
}