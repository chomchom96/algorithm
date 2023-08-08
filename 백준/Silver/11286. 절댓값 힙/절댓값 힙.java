import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1) > Math.abs(o2)) {
					return Math.abs(o1) - Math.abs(o2);
				}else if(Math.abs(o1) == Math.abs(o2)) {
					return o1 - o2;
				}else {
					return -1;
				}
			}
			
		});
		int n = Integer.parseInt(br.readLine());
		while (n-->0) {
			int cmd = Integer.parseInt(br.readLine());
			if (cmd == 0) if (pq.isEmpty()) System.out.println(0); else System.out.println(pq.poll());
			else pq.add(cmd);
		}
		
	}

}
