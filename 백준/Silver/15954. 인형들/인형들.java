import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	public static void main(String[] args) throws IOException {
	    StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    double[] nums = new double[n];
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < n; i++) nums[i] = Double.parseDouble(st.nextToken());
	    double ans = Double.MAX_VALUE;
	    for (int k = K; k <= n; k++) {
		    for (int i = 0; i < n - k + 1; i++) {
		    	double avg = 0;
		    	for (int j = i; j < i + k; j++) avg += nums[j];
		    	avg /= k;
		    	double dev = 0;
		    	for (int j = i; j < i + k; j++) dev += Math.pow(nums[j] - avg, 2) / k;
		    	
		    	double stdev = Math.sqrt(dev);
		    	ans = Math.min(ans, stdev);
		    }
	    }
	    System.out.println(ans);
	}
}