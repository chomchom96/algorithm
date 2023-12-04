import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class Main {

	static StringTokenizer st;
	
    public static void main(String[] args) throws IOException {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] arr1 = new int[n + 1];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= n; i++) 
    		arr1[i] = Integer.parseInt(st.nextToken()) + arr1[i-1];
    	
    	
    	int m = Integer.parseInt(br.readLine());
    	int[] arr2 = new int[m + 1];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 1; i <= m; i++) 
    		arr2[i] = Integer.parseInt(st.nextToken()) + arr2[i-1];
    	
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	//첫번째 배열의 부분합 해싱
    	for (int i = 0; i < n; i++) {
    		for (int j = i + 1; j <= n; j++) {
    			int partialSum = arr1[j] - arr1[i];
    			if (map.get(partialSum) != null) map.put(partialSum, map.get(partialSum) + 1);
    			else map.put(partialSum, 1);
    		}
    	}
    	
    	long cnt = 0L;
    	
    	for (int i = 0; i < m; i++) {
    		for (int j = i + 1; j <= m; j++) {
    			int partialSum = arr2[j] - arr2[i];
    			if (map.get(T - partialSum) != null) cnt += map.get(T - partialSum); 
    		}
    	}
    
    	System.out.println(cnt);	
    }
}