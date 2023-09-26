import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

	static int toss;
	static double tail, head;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        double N = Double.parseDouble(br.readLine());
        int[][] arr = new int[3][2];
        st = new StringTokenizer(br.readLine());
        arr[0][0] = Integer.parseInt(st.nextToken());
        arr[1][0] = Integer.parseInt(st.nextToken());
        arr[2][0] = Integer.parseInt(st.nextToken());
        arr[2][1] = Integer.parseInt(st.nextToken());
        arr[1][1] = Integer.parseInt(st.nextToken());
        arr[0][1] = Integer.parseInt(st.nextToken());
        
        if (N == 1) {
        	int sum = 0;
        	int max = 0;
        	for (int i =0 ; i < 3; i++) for (int j = 0; j < 2; j++) {
        		sum += arr[i][j]; max = Math.max(arr[i][j], max);
        	}
        	System.out.println(sum - max); System.exit(0);
        }
        
        int minAF = Math.min(arr[0][0], arr[0][1]);
        int minBE = Math.min(arr[1][0], arr[1][1]);
        int minCD = Math.min(arr[2][0], arr[2][1]);
        
        int minV = Math.min(minAF, Math.min(minBE, minCD));
        int maxV = Math.max(minAF, Math.max(minBE, minCD));
        
        long sum = 0L;
        if (minV == maxV) sum += minV * 5 * N * N;
        else {
        	sum += 4 * (minAF + minBE + minCD);
        	sum += (5 * N - 6) * (N - 2) * (minV);
        	sum += (8 * N - 12) * (minAF + minBE + minCD - maxV);
        }
        System.out.println(sum);
    }
    
}