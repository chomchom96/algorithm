import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main {
	
	static boolean isPrime(int n) {
		if (n == 1) return false;
		if (n == 2) return true;
		for (int i = 2; i * i <= n; i++) if (n % i == 0) return false; 
		return true;
	}
	
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> primeList = new ArrayList<Integer>();
		for (int i = 2; i < N; i++) if (isPrime(i)) primeList.add(i);
		int size = primeList.size() - 1;		
		int left = 0;
		int right = 0;
		int sum = 0;
		int cnt = 0;
		while (left < size || right < size) {
			if(sum == N) {
				sum -= primeList.get(left++);
				cnt++;
			}
			else if (sum < N) sum += primeList.get(right++);
			else sum -= primeList.get(left++);
		}
		if (isPrime(N)) cnt++;
		System.out.println(cnt);
	}

}