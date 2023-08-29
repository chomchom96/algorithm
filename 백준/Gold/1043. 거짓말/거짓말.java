import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1]; // union
		boolean[] jinsil = new boolean[n + 1]; // 진실을 아는 사람 확인
		for (int i = 1; i <= n; i++) parent[i] = i;
		
		st = new StringTokenizer(br.readLine());
		int jNum = Integer.parseInt(st.nextToken());
		while (jNum --> 0) jinsil[Integer.parseInt(st.nextToken())] = true;

		List<List<Integer>> parties = new ArrayList<>();
		for (int i = 0; i <= m; i++) parties.add(new ArrayList<Integer>());
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int pNum = Integer.parseInt(st.nextToken());
			while (pNum --> 0) parties.get(i).add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i <= m; i++) {
			List<Integer> party = parties.get(i);
			int init = party.get(0);
			for (int p : party) union(init, p);
		}
				
		for (int i = 1; i <= n; i++) {
			if (jinsil[i]) jinsil[find(i)] = true;
			if (jinsil[find(i)]) jinsil[i] = true;
		}
		
		int ans = 0;
		for (int i = 1; i <= m; i++) {
			List<Integer> party = parties.get(i);
			int init = party.get(0);
			if (!jinsil[find(init)]) ans++;
		}
		
//		for (int i = 1; i <= n; i++) System.out.print(parent[i] + " ");
//		for (int i = 1; i <= n; i++) System.out.print(jinsil[i] + " ");
		
		System.out.println(ans);
	}
	
	static void union(int n, int m) {
		n = find(n);
		m = find(m);
		
		if (n > m) parent[n] = m;
		else parent[m] = n;
	}
	
	static int find(int n) {
		if (parent[n] != n) {
			return parent[n] = find(parent[n]); // 트리 내 모든 자식 노드의 부모를 루트 노드로 !
		}
		return n;
	}
}