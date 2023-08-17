import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int a, b, num, depth;
	static int cnt;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		br.close();
		bfs(a,1);
    }
    static void bfs(int n,int m) {
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {n, m});
    	while (!queue.isEmpty()) {
    		int[] arr = queue.poll();
    		num = arr[0];
    		depth = arr[1];
    		if (num == b) {
    			System.out.println(depth); System.exit(0);
    		}
    		else if (num <= b/2 && depth <= (int) (Math.log(b/a) / Math.log(2)) + 1) {
    			queue.add(new int[] {2*num, depth + 1});
    			queue.add(new int[] {10 * num + 1, depth + 1});
    		}
    	}
    	System.out.println(-1);
    }
}