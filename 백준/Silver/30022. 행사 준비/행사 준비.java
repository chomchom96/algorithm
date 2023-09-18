import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int[][] price = new int[n][2];
		List<int[]> diff = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int aPrice = Integer.parseInt(st.nextToken());
			int bPrice = Integer.parseInt(st.nextToken());
			
			price[i][0] = aPrice;
			price[i][1] = bPrice;
			diff.add(new int[] {i, aPrice - bPrice});
		}

		Comparator<int[]> myComparator = new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 return o1[1] - o2[1];
             }
        };
         
		Collections.sort(diff, myComparator);
		long ans = 0L;
		for (int i = 0; i < a; i++) ans += price[diff.get(i)[0]][0];
		for (int i = a; i < a + b; i++) ans += price[diff.get(i)[0]][1];
		
		System.out.println(ans);
	}
}