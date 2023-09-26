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
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
        	st = new StringTokenizer(br.readLine());
        	toss = Integer.parseInt(st.nextToken());
        	tail = Double.parseDouble(st.nextToken());
        	head = Double.parseDouble(st.nextToken());
        	DP();
        }
    }

	static void DP() {
		double side = 1D - tail - head;
		double[][] DP = new double[toss + 1][toss + 1];
		DP[1][0] = head;
		for (int i = 1; i <= toss; i++) DP[1][i] = (double) i;
		for (int i = 2; i <= toss; i++) for (int j = 0; j <= toss - i; j++) 
				DP[i][j] = side * DP[i-1][j] 
				+ tail * (DP[i-1][j+1] - 1) 
				+ head * (DP[i-1][Math.max(j-1, 0)] + 1);
		DecimalFormat format = new DecimalFormat("0.0000");
		System.out.println(format.format(DP[toss][0]));
	}
      
}