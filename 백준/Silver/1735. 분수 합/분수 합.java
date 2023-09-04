import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int gcd;
    
	public static void main(String[] args) throws IOException {
	    StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    st = new StringTokenizer(br.readLine());
	    int a1 = Integer.parseInt(st.nextToken());
	    int b1 = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    int a2 = Integer.parseInt(st.nextToken());
	    int b2 = Integer.parseInt(st.nextToken());
	    
	    int a3 = a1*b2 + a2*b1;
	    int b3 = b1 * b2;
	    gcd(a3, b3);
	    System.out.println(a3/gcd  + " " + b3/gcd );
	}
    
	static void gcd(int a, int b) {
		if (a % b == 0) gcd = b;
		else {
			if (a > b) gcd(b, a % b);
			else gcd(a, b % a);
		}
	}
}