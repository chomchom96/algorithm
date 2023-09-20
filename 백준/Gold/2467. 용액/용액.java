import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] solution = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) solution[i] = Integer.parseInt(st.nextToken());
        int lP = 0; 
        int rP = n - 1;
        int lAns = 0;
        int rAns = 0;
        int min = Integer.MAX_VALUE;
        
        while (lP < rP) {
        	int tempSum = solution[lP] + solution[rP];
        	if (Math.abs(tempSum) <= min) {
        		min = Math.abs(tempSum); lAns = lP; rAns = rP;
        	}
        	if (tempSum == 0) break;
        	else if (tempSum < 0) lP++;
        	else rP--;
        }
        System.out.println(solution[lAns] + " " + solution[rAns]);
    }
}