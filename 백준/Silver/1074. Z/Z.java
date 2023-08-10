import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int n,r,c,cnt;
	
	 public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       r = Integer.parseInt(st.nextToken());
       c = Integer.parseInt(st.nextToken());
       System.out.println(div(r,c));
	 }
	 
	 static int div(int r, int c) {
		 if (n!=0) {
			n--;
			int s = (int) Math.pow(2, n);
			if (r < s && c < s) div(r,c);
        	else if (r < s && c >= s) {
        		cnt += s*s; div(r,c-s);
        	}
        	else if (c < s && r >= s) {
        		cnt += 2*s*s; div(r-s,c);
        	}
        	else {
        		cnt += 3*s*s; div(r-s,c-s);
        	}
		 }
		return cnt;
	 }
}