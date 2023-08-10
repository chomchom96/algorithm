import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int n,r,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int cnt  = 0;
        while (n!=0) { // size 1 까지 탐색
        	n--;
        	int s = (int) Math.pow(2, n); // s for size
        	if (r < s && c < s) continue;
        	else if (r < s && c >= s) {
        		cnt += s*s; c -= s;
        	}
        	else if (c < s && r >= s) {
        		cnt += 2*s*s; r -= s;
        	}
        	else {
        		cnt += 3*s*s; r -= s; c -= s;
        	}
        }
        System.out.println(cnt);
    }
}