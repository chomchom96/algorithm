import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] pool;
	static ArrayList<Integer> arr = new ArrayList<>();
	static Set<ArrayList<Integer>> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		pool = new int[N];
		for (int i = 0; i < N; i++) pool[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(pool);

		NM(0,0);
		
	}
	
	static void NM(int cnt, int start) {
		
		if(cnt == M) {
			if (!set.contains(arr)) {
				set.add(arr);
				for(int m = 0; m < cnt;m++) {
					System.out.print(arr.get(m)+" ");
					if(m == cnt-1) {
						System.out.println();
					}
				}
				return;
			}
			else return;
		}
		for (int i = start; i <N; i ++) {	 
			arr.add(pool[i]);
			NM(cnt+1, i);
			arr.remove(arr.size() - 1);
		}		
	}
}