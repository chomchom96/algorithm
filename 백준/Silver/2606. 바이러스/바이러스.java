import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int node;
	static int edge;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		visited = new boolean[node + 1];
		visited[1] = true;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= node; i++) {
		    graph.add(new ArrayList<>());
		}

        for (int i = 0; i < edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);

        }

        BFS(visited, graph);
        int ans = 0;
        for (int i = 0; i < visited.length; i++) {
        	if (visited[i]) {
        		ans += 1;
        	}
        }
        System.out.println(ans - 1);
	}
	
	
	
	static void BFS(boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int c = queue.poll();
			for (int i: graph.get(c)) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}