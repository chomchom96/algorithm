import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Line implements Comparable<Line> {
	int x, y;
	
	public Line(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Line o) {
		return this.x - o.x;
	}
	
}

public class Main {

	static StringTokenizer st;
	static int N;
	
    public static void main(String[] args) throws IOException {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	PriorityQueue<Line> pq = new PriorityQueue<>();
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		pq.offer(new Line(x,y));
    	}
    	int sum = 0;
    	int start = Integer.MIN_VALUE;
    	int end = Integer.MIN_VALUE;
    	
    	while (!pq.isEmpty()) {
    		Line l = pq.poll();
    		int ls = l.x;
    		int le = l.y;
    		if (ls > end) {
    			sum += end - start;
    			start = ls;
    			end = le;
    		}
    		else if (le > end) {
    			end = le;
    		}
    	}
    	sum += end - start;
    	
    	System.out.println(sum);
    }
}