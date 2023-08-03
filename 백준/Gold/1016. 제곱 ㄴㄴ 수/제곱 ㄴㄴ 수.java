import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		long[] list = new long[(int) (max-min+1)];
		double n = Math.sqrt(max);
		for (long i = 2; i <= n; i++) {
			long s = i*i;
			long sn = 0;
			if (min % s != 0) sn = s - (min % s);
			for (long j = sn; j < max-min+1; j+=s) list[(int) j] = 1;	
		}
		int ans = 0;
		for (long a : list) {
			if (a != 1) ans++;
		}
		System.out.println(ans);
		sc.close();
	}
}