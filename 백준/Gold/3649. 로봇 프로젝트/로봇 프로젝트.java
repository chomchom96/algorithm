import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] legos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
        	int x = Integer.parseInt(s);
        	x *= 10000000;
        	int n = Integer.parseInt(br.readLine());
        	legos = new int[n];
        	for (int i = 0; i < n; i++) legos[i] = Integer.parseInt(br.readLine());
        	Arrays.sort(legos);
        	// 투 포인터 해 찾기
        	int left = 0;
        	int right = n - 1;
        	int sum = 0;
        	boolean flag = false;
        	while (left < right) {
        		sum = legos[left] + legos[right];
        		if (sum == x) {
        			sb.append("yes" + " " + legos[left] + " " + legos[right] + "\n");
        			flag = true;
        			break;
        		}
        		if (sum < x) left++;
        		if (sum > x) right--;
        	}
        	if (!flag) {
        		sb.append("danger" + "\n");
        	}
        	
        }
        System.out.println(sb);
    	
    }
}