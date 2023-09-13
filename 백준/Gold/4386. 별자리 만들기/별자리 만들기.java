import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	
	int from, to;
	double value;
	public Edge(int from, int to, double value) {
		this.from = from;
		this.to = to;
		this.value = value;
	}
	@Override
	public int compareTo(Edge e) {
		return (int) (value * value - e.value * e.value);
	}

}

public class Main {
	static int N;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Queue<Edge> queue = new PriorityQueue<>();
		
		double[][] coordinates = new double[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double from = Double.parseDouble(st.nextToken());
			double to = Double.parseDouble(st.nextToken());
			coordinates[i] = new double[] {from, to};
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N; j++) {
				if (i != j) {
					double[] first_coord = coordinates[i];
					double[] second_coord = coordinates[j];
					queue.add(new Edge(i, j, Math.sqrt(Math.pow(first_coord[0] - second_coord[0], 2) + Math.pow(first_coord[1] - second_coord[1], 2))));
				}
			}
		}
		
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) parent[i] = i;
		double ans = 0;
		while (!queue.isEmpty() && !isUnion()) {
			Edge cur = queue.poll();
			int from = cur.from;
			int to = cur.to;
			double value = cur.value;
			if (union(from, to)) ans += value;
		}
		System.out.println(ans);
	}
	
	static boolean isUnion() {
		int p1 = parent[1];
		for (int i = 1; i <= N; i++) {
			if (parent[i] != p1) return false;
		}
		return true;
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		if (a > b) parent[a] = b;
		else parent[b] = a;
		return true;
	}
	
	static int find(int a) {
		if (parent[a] != a) {
			return parent[a] = find(parent[a]);
		}
		return a;
	}
}