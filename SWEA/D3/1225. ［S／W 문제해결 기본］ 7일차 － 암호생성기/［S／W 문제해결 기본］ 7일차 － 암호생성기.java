import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = 10;
        while (TC --> 0) {
        	int t = Integer.parseInt(br.readLine());
        	Queue<Integer> queue = new LinkedList<>();
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	while (st.hasMoreTokens()) queue.add(Integer.parseInt(st.nextToken()) % 120);
        	StringBuilder sb = new StringBuilder();
        	sb.append("#" + t + " ");
        	int i = 1;
        	while (true) {
        		int head = queue.poll();
        		if (i == 6) i = 1;
        		if (head > i) {
        			head -= i++;
        			queue.offer(head);
        		}
        		else {
        			while (!queue.isEmpty()) {
        				sb.append(queue.poll() + " ");
        			}
        			sb.append(0);
        			System.out.println(sb);
        			break;
        		}
        	}
        }     
    }
}