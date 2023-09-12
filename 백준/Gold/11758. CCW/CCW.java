import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st;
		st= new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st= new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		
		int[] vector1 = {x1-x2, y1-y2};
		int[] vector2 = {x2-x3, y2-y3};
		int product = vector1[1]*vector2[0] - vector1[0]*vector2[1];
		
		int ans = 0;
		if (product > 0) ans = -1;
		if (product < 0) ans = 1;
		System.out.println(ans);
	}
}