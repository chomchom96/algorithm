import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] max = new int[3];
		int[] min = new int[3];
		int[] max_tmp = new int[3];
		int[] min_tmp = new int[3];
		while (n --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i0 = Integer.parseInt(st.nextToken());
			max_tmp[0] = i0 + Math.max(max[0], max[1]);
			min_tmp[0] = i0 + Math.min(min[0], min[1]);
			int i1 = Integer.parseInt(st.nextToken());
			max_tmp[1] = i1 + Math.max(max[0], Math.max(max[1], max[2]));
			min_tmp[1] = i1 + Math.min(min[0], Math.min(min[1], min[2]));
			int i2 = Integer.parseInt(st.nextToken());
			max_tmp[2] = i2 + Math.max(max[1], max[2]);
			min_tmp[2] = i2 + Math.min(min[1], min[2]);
			
			max = Arrays.copyOf(max_tmp, 3);
			min = Arrays.copyOf(min_tmp, 3);
		}
		
		System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
	}
}