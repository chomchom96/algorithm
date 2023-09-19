import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int to;
		int weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] inDegree = new int[n + 1];
        List<Node>[] graph = new ArrayList[n + 1];
        List<Node>[] graph2 = new ArrayList[n + 1];
        int[] weight = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
        	graph[i] = new ArrayList<Node>();
        	graph2[i] = new ArrayList<Node>();
        }
        
        while (m --> 0) { // 입력 및 그래프
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int value = Integer.parseInt(st.nextToken());
        	inDegree[end]++;
        	graph[start].add(new Node(end, value));
        	graph2[end].add(new Node(start, value));
        }
        
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        int[] weightSum = new int[n + 1];
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
        	int cur = queue.poll();
        	for (Node next : graph[cur]) {
        		inDegree[next.to]--;
        		weightSum[next.to] = Math.max(weightSum[next.to], weightSum[cur] + next.weight);
        		if (inDegree[next.to] == 0) queue.offer(next.to);
        	}
        }
        
        boolean[] visited = new boolean[n + 1];
        int cnt = 0;
        queue.offer(end);
        
        while (!queue.isEmpty()) {
        	int cur = queue.poll();
        	for (Node next : graph2[cur]) {
        		if (weightSum[cur] == weightSum[next.to] + next.weight) {
        			cnt++;
	        		if (!visited[next.to]) {
	        			queue.offer(next.to);
	        			visited[next.to] = true;
	        		}
        		}
        	}
        }
        
        System.out.println(weightSum[end]);
        System.out.println(cnt);
    }
}