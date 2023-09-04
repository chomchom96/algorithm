import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> littleQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> bigQueue = new PriorityQueue<>();
		int num = Integer.parseInt(br.readLine());
		System.out.println(num);
		littleQueue.add(num);
		n--;
		while (n --> 0) {
			int cur = Integer.parseInt(br.readLine());
			
			if (cur > littleQueue.peek()) {
				if (bigQueue.isEmpty()) bigQueue.add(cur);
				else if (cur >= bigQueue.peek()) {
					bigQueue.add(cur);
				}
				else {
					littleQueue.add(cur);
				}
			}
			else {
				if (bigQueue.isEmpty()) bigQueue.add(littleQueue.poll());
				littleQueue.add(cur);
			}
			if (bigQueue.size() > littleQueue.size() + 1) littleQueue.add(bigQueue.poll());
			if (littleQueue.size() > bigQueue.size() + 1) bigQueue.add(littleQueue.poll());
//			System.out.println(littleQueue + " " + bigQueue);
			if (bigQueue.size() > littleQueue.size()) System.out.println(bigQueue.peek()); 
			else System.out.println(littleQueue.peek());
		}
		
	}

}