import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class SegmentTree {
		long tree[];
		int height;
		
		public SegmentTree(int arrLength) {
			int height = (int) Math.ceil(Math.log(arrLength) / Math.log(2));
			this.height = height;
			int len = (int) Math.pow(2, height + 1);
			this.tree = new long[len];
 		}
		
		public long init(long[] arr, int node, int start, int end) {
		    if (start == end) return tree[node] = arr[start];
		    return tree[node] = init(arr, node * 2, start, (start + end) / 2) + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
		}
		
		// 수정할 값 - 원래 값 해서 diff 로 놓고 수정하는 게 훨씬 편함
		public void update(int node, int start, int end, int idx, long diff) {
			if (idx < start || end < idx) return;
			
			tree[node] += diff;
			
			if (start != end) { // 이분 탐색
				int mid = (start + end) / 2;
				update(node * 2, start, mid, idx, diff);
				update(node * 2 + 1, mid + 1, end, idx, diff);
			}
			
		}
		
		public long sum(int node, int start, int end, int left, int right) { //left ~ right 탐색을 이분 탐색처럼
			if (left > end || right < start) return 0;
			
			if (left <= start && end <= right) return tree[node];
			
			int mid = (start + end) / 2;
			return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1,mid + 1, end, left, right);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] arr = new long[n+1];
		for (int i = 1; i <= n; i++) arr[i] = Long.parseLong(br.readLine());
		
		SegmentTree sTree = new SegmentTree(n);
		sTree.init(arr, 1, 1, n);
			
		int s = m + k;
        
		while (s --> 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				int node = Integer.parseInt(st.nextToken());
				long value = Long.parseLong(st.nextToken());
				long diff = value - arr[node];
				arr[node] = value;
				sTree.update(1, 1, n, node, diff);
			}
			if (cmd == 2) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				System.out.println(sTree.sum(1, 1, n, from, to));
			}
		}
	}
}