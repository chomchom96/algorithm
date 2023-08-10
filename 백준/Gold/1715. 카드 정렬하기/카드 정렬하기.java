import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-->0) pq.add(Integer.parseInt(br.readLine()));
        int ans = 0;
        while (pq.size() > 1) {
        	int a =pq.poll();
        	int b = pq.poll();
        	ans += a + b;
        	pq.add(a+b);
        }
        System.out.println(ans);
	}
}