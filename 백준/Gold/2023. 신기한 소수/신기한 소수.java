import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static int n;
	static Set<Integer> primes;
	static int[] primePrimes = {1,3,5,7,9};
	static StringBuilder sb;
	
	static boolean isPrime(int num) {
		if (num == 1) return false;
		if (num == 2 || num == 3) return true;
		else {
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) return false;
			}
			return true;
		}
	}

	public static void getResult(int num, int depth) {
        if (depth == n) {
            if (isPrime(num)) sb.append(num + "\n");
            return;
        }
        for (int i = 0; i < 5; i ++) {
            int next = num * 10 + primePrimes[i];
            if (isPrime(next)) getResult(next, depth + 1);
        }
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        getResult(2,1);
        getResult(0,0);
        System.out.println(sb);
    }
   
}