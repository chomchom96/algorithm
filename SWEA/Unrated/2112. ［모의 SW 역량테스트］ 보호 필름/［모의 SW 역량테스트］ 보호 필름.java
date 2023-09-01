import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
	static int d,w,k,ans;
	static int[][] arr, cArr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        l :for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	d = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	arr = new int[d][w];
        	cArr = new int[d][w];
        	for (int i = 0; i < d; i++) {
        		st = new StringTokenizer(br.readLine());
        		for (int j = 0; j < w; j++) arr[i][j] = cArr[i][j] = Integer.parseInt(st.nextToken());
        	}
        	if (k == 1) {System.out.println("#" + t + " " + 0); continue l;}
        	
        	System.out.print("#" + t + " ");
        	ans = Integer.MAX_VALUE;
        	backTrack(0, 0);
        	System.out.println(ans);
        }
    }
    
    static void backTrack(int row, int depth) {
    	
    	if (isValid()) {
    		ans = Math.min(ans, depth);
    		return;
    	}
    	if (row == d) return;
    	backTrack(row + 1, depth);
    	for (int i = 0; i < w; i++) cArr[row][i] = 0;
    	backTrack(row + 1, depth + 1);
    	for (int i = 0; i < w; i++) cArr[row][i] = 1;
    	backTrack(row + 1, depth + 1);
    	for (int i = 0; i < w; i++) cArr[row][i] = arr[row][i];
    }
    
    static boolean isValid() {
    	boolean flag = true;
    	l: for (int i = 0; i < w; i++) {
    		int streak = 0;
    		for (int j = 1; j < d; j++) {
    			if (cArr[j-1][i] == cArr[j][i]) streak++;
    			else streak = 0;
    			if (streak >= k - 1) continue l;
    		}
    		flag = false;
    		break;
    	}
    	return flag;
    }
}