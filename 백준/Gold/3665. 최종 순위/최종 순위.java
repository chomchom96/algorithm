import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		
		while (T-->0) {
			int N = Integer.parseInt(br.readLine());
			int[] inDegree = new int[N+1];
			int[] arr = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			List<Integer>[] list = new ArrayList[N+1]; // 인접 리스트
			for (int i=0; i<=N; i++) list[i] = new ArrayList<Integer>();
			for (int i=1; i<=N; i++) {
				int from = arr[i];
				for(int j = i+1; j <= N; j++) {
					list[from].add(arr[j]); // 자신보다 순위가 낮은 모든 플레이어들의 번호를 저장(노드 연결)
					inDegree[arr[j]]++;
				}
			}
						
			int M = Integer.parseInt(br.readLine());
			while (M --> 0) {
				st = new StringTokenizer(br.readLine());
				int front = Integer.parseInt(st.nextToken());
				int back = Integer.parseInt(st.nextToken());
				// 앞 -> 뒤 순위인 경우
				if (list[front].contains(back)) {
					list[front].remove((Integer) back);
					list[back].add(front);
					inDegree[front]++;
					inDegree[back]--;
				} 
				else {
					list[back].remove((Integer) front);
					list[front].add(back);
					inDegree[back]++;
					inDegree[front]--;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			Queue<Integer> queue = new LinkedList<>();

			for(int i=1; i<=N; i++) if(inDegree[i]==0) queue.offer(i);
				
			if (queue.size() > 1) {
				System.out.println("?");
				continue;
			}
						
			boolean impossible = false;
			
			for (int i=1;i<=N;i++) {
				if (queue.isEmpty()) { // 위상정렬 결과가 모순
					impossible=true;
					break;
				}
				
				int from = queue.poll();
				sb.append(from).append(" ");
				
				for (int to : list[from]) {
					inDegree[to]--;
					if(inDegree[to] == 0) queue.offer(to);
				}
			}
			if (impossible) {
				sb.setLength(0);
				sb.append("IMPOSSIBLE");
			}
			
			System.out.println(sb);
		}
	}

}
