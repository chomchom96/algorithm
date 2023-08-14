import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[][] rectangle;
	static double[][] slope;
	
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rectangle = new int[n][4];
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	rectangle[i][0] = Integer.parseInt(st.nextToken());
        	rectangle[i][1] = Integer.parseInt(st.nextToken());
        	rectangle[i][2] = Integer.parseInt(st.nextToken());
        	rectangle[i][3] = Integer.parseInt(st.nextToken());     
        }
        double[][] slope = new double[n][2];
        for (int i = 0; i < n; i++) {
        	double[] slope_temp = find_slope(rectangle[i]);
        	slope[i] = slope_temp;
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < 2; j++) {
        		int cnt = 0;
        		double s = slope[i][j];
        		for (int k = 0; k < n; k++) {
        			if (s <= slope[k][0] && s >= slope[k][1]) cnt++;
        		}
        		ans = Math.max(ans, cnt);
        	}
        }
        System.out.println(ans);
    }
    
    
    public static double[] find_slope(int[] l){
        double[] slope = new double[2];
    	int x1 = l[0];
        int y1 = l[1];
        int x2 = l[2];
        int y2 = l[3];
        slope[0] = (double) Math.max(y1, y2) / (double) Math.min(x1, x2);
        slope[1] = (double) Math.min(y1, y2) / (double) Math.max(x1, x2);
        return slope;
    }
}