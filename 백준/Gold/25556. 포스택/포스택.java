import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MIN_VALUE;
        List<Integer> minarr = new ArrayList<>();
        for (int i = 0; i < 4; i++) minarr.add(min);
        for (int num : arr) {
        	l : for (int i = 0; i < 4; i++) {
        		if (minarr.get(i) < num) {
        			minarr.set(i, num);
        			minarr.sort(Collections.reverseOrder());
        			break l;
        		}
        		else {
        			if (i==3) {
        				System.out.println("NO");
        				System.exit(0);
        			}
        		}
        	}  	
        }
        System.out.println("YES");
    }
}