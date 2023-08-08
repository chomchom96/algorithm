import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int n = Integer.parseInt(br.readLine());
		while (n-->0) {
			int cmd = Integer.parseInt(br.readLine());
			if (cmd == 0) if (pq.isEmpty()) System.out.println(0); else System.out.println(pq.poll());
			else pq.add(cmd);
		}
	}
}