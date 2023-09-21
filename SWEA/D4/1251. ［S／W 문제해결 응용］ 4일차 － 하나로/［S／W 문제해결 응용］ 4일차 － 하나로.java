import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Island {
	long xC;
	long yC;
	
	public Island(long xC, long yC) { 
		this.xC = xC;
		this.yC = yC;
	}
}

class E implements Comparable<E> {
	int from;
	long weight;
	public E(int from, long weight) {
		this.from = from;
		this.weight = weight;
	}
	@Override
	public int compareTo(E o) {
		// TODO Auto-generated method stub
		if (weight - o.weight > 0) return 1;
		else return -1;
	}	
}

// 이제 프림으로
// 임의의 노드에서 시작 (그냥 1번)
public class Solution {
	static int n, m;
	static double tax;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for (int tc = 1; tc <= T; tc++) {
    		n = Integer.parseInt(br.readLine());
    		int[] xC = new int[n];
    		int[] yC = new int[n];
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < n; i++) xC[i] = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < n; i++) yC[i] = Integer.parseInt(st.nextToken());
    		tax = Double.parseDouble(br.readLine());
    		
    		List<Island> islands = new ArrayList<>();
    		for (int i = 0; i < n; i++) islands.add(new Island(xC[i], yC[i]));
    		List<E>[] graph = new ArrayList[n + 1];
    		for (int i = 0; i <= n; i++) graph[i] = new ArrayList<E>();
    		for (int i = 0; i < n; i++) {
    			for (int j = 0; j < n; j++) {
    				if (i == j) continue;
    				else {
    					Island a = islands.get(i);
    					Island b = islands.get(j);
    					graph[i+1].add(new E(j+1, distance(a,b)));
    					graph[j+1].add(new E(i+1, distance(a,b)));
    				}
    			}
    		}
    		boolean[] visited = new boolean[n + 1];
    		visited[1] = true;
    		
    		PriorityQueue<E> queue = new PriorityQueue<>();
    		for (E e : graph[1]) queue.add(e);
    		
    		long sum = 0;
    		int cnt = 0;
    		
    		while (!queue.isEmpty() && cnt < n - 1) {
    			E cur = queue.poll();
    			if (visited[cur.from]) continue;
    			else {
    				visited[cur.from] = true;
    				cnt++;
    				sum += cur.weight;
    				for (E e : graph[cur.from]) if (!visited[e.from]) queue.add(e);
    			}
    		}
    		
    		System.out.println("#" + tc + " " +  Math.round((sum * tax)));
    		}
    	}

	static long distance(Island a, Island b) {
    	long xDiff = a.xC - b.xC;
    	long yDiff = a.yC - b.yC;
    	return  xDiff * xDiff + yDiff * yDiff;
    }
    
}