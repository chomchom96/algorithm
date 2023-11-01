import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static boolean[] sieve;
	
    public static void main(String[] args) throws IOException {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int T = Integer.parseInt(br.readLine());
         init();
         while (T --> 0) {
        	 int c = Integer.parseInt(br.readLine());
        	 partition(c);
         }
    }

	private static void partition(int c) {
		int cnt = 0;
		for (int i = 2; i <= c/2; i++) if (!sieve[i] && !sieve[c-i]) cnt++;
		System.out.println(cnt);
		
	}

	private static void init() {
		sieve = new boolean[1000001];
		sieve[0] = sieve[1] = true;
		for (int i = 2; i <= 1000; i++) if (!sieve[i]) for (int j = 2; j <= 1000000 / i; j++) sieve[i * j] = true;
		
	}
}