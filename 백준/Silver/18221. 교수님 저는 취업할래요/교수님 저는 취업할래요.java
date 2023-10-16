import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class Main {
	
    public static void main(String[] args) throws IOException {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// 1. 직선 거리가 5 이상 -> 제곱 차이의 합이 25보다 크거나 같아야 함
    	// 2. 형성한 직사각형 사이 사람들의 수가 3 이상
    	int n = Integer.parseInt(br.readLine());
    	int sr = 0, sc = 0, pr = 0, pc = 0;
    	List<int[]> students = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < n; j++) {
    			int cur = Integer.parseInt(st.nextToken());
    			switch (cur) {
    			case (1): 
    				students.add(new int[] {i,j}); break;
    			case (2):
    				sr = i; sc = j; break;
    			case (5):
    				pr = i; pc = j; break;
    			}
    		}
    	}
    	if ((sr - pr) * (sr - pr) + (sc - pc) * (sc - pc) < 25) {
    		System.out.println(0);
    		System.exit(0);
    	}
    	int cnt = 0;
    	for (int[] s : students) {
    		if (((s[0] - sr) * (s[0] - pr) <= 0) && ((s[1] - sc) * (s[1] - pc) <= 0)) cnt++;
    	}
    	System.out.println(cnt >= 3? 1: 0);
    }
}