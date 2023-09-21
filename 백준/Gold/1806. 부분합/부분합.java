import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	if (i > 0) arr[i] += arr[i - 1];
        }
                
        int leftPointer = 0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
    		if (arr[i] >= s) {len = Math.min(i + 1, len); break;}
    	}
        
        while (leftPointer < n) {
        	
        	if (len == 1) break;
        	
        	
        	
        	for (int i = 1; i < Math.min(len, n - leftPointer); i++) {
        		if (arr[leftPointer + i] - arr[leftPointer] >= s) 
        			{len = Math.min(len, i); break;}
        	}
        	leftPointer++;
        }      
        System.out.println(len == Integer.MAX_VALUE? 0 : len); 
    }
}