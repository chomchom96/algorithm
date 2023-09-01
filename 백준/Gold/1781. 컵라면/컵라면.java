import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class cup implements Comparable<cup> {
	int limit;
	int prize;
	public cup(int limit,int prize) {
		this.limit = limit;
		this.prize = prize;
	}
	
	public int compareTo(cup o) {
		return (limit - o.limit== 0)? o.prize - prize : limit - o.limit;
	}
}


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		ArrayList<cup> arr=new ArrayList<cup>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int prize = Integer.parseInt(st.nextToken());
			arr.add(new cup(time,prize));
		}
		
		Collections.sort(arr);
		
		for (int i = 0; i < N; i++) {
			int time=arr.get(i).limit;
			int prize=arr.get(i).prize;
			queue.add(prize);
			if (time < queue.size()) queue.poll();
		}
		
		long sum = 0;
		
		while(!queue.isEmpty()) sum += queue.poll();
		
		System.out.println(sum);
	}
}