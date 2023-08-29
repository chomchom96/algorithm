import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
		
		while (m-->0) {
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (flag == 0) {			
				union(a,b);
			}
			else {
				if (find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	
	static void union(int n, int m) {
		n = find(n);
		m = find(m);
		parent[m] = n; // 두 번째 트리의 부모를 첫 번째 트리 부모에 자식으로 연결
	}
	
	static int find(int n) {
		if (parent[n] != n) {
			return parent[n] = find(parent[n]); // 트리 내 모든 자식 노드의 부모를 루트 노드로 !
		}
		return n;
	}
}