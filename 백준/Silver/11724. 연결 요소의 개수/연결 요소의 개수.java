import java.io.*;
import java.util.*;

public class Main {
    static int node, edge;
    static List<List<Integer>> I = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        visited = new boolean[node + 1];
        for (int i = 0; i <= node; i++) {
            I.add(new ArrayList<>()); // 이차원 리스트, 그래프 표현
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            I.get(A).add(B);
            I.get(B).add(A); // graph에 (A,B), (B,A) 추가
        }
        int ans = 0;
        for (int i = 1; i <= node; i++) {
        	if (!visited[i]) ans += bfs(i);
        }
        System.out.println(ans);
    }

    private static int bfs(int x) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(x);
		
		visited[x]=true;

		int []depth=new int[node+1];
		for(int i=1;i<=node;i++) depth[i]=-1;
		while(!queue.isEmpty()) {
			int size=queue.size();
			while(size-->0) {
				int q=queue.poll();
				
				for(int i: I.get(q)) {
					if(!visited[i]) {
						visited[i]=true;
						queue.add(i);
					}
				}
			}
			
		}
		
		return 1;
	}
}
