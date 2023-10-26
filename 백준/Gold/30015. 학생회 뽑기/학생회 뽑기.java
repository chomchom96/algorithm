import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int k = Integer.parseInt(st.nextToken()); 
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int check = (int) Math.pow(2, (int) (Math.log(arr[n-1]) / Math.log(2)));
		int x = 0;
		List<Integer> candidate = new ArrayList<>();
		for (int i = 0; i < n; i++) candidate.add(i);
		
		while (check >= 1) {
			int cnt = 0;
			for (int i : candidate) {
				if ((check & arr[i]) != 0) {	
					cnt++;
				}
			}
			if (cnt >= k) {
				x |= check;
				List<Integer> c2 = new ArrayList<>();
				for (int i : candidate) if ((arr[i] & check) != 0) c2.add(i);
				candidate = c2;
			}
			check /= 2;
		}
		
		System.out.println(x);
	}
}