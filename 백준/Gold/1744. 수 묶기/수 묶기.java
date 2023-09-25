import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> nQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
        	int c = Integer.parseInt(br.readLine());
        	if (c > 0) pQueue.add(c);
        	else nQueue.add(c);
        	
        }
        int sum = 0;
        while (pQueue.size() > 1) {
        	int cur = pQueue.poll();
        	if (cur == 1) sum += cur;
        	else if (pQueue.peek() > 1) sum += cur * pQueue.poll();
    		else sum += cur;
        	
        }
        
        while (nQueue.size() > 1) {
        	int cur = nQueue.poll();
        	sum += cur * nQueue.poll();
        }
        
        while (!pQueue.isEmpty()) sum += pQueue.poll();
        while (!nQueue.isEmpty()) sum += nQueue.poll();
        
        System.out.println(sum);
    }
}