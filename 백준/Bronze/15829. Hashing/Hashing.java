import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt(); // 1~50
		long m = 1234567891;
		String str = sc.next();
		
		char[] word = str.toCharArray(); // a~z
		long ans = 0;
		long[] pow = new long[l];
		pow[0] = 1L;
		for (int i = 1; i < l; i++) pow[i] = (long) (pow[i-1] * 31) % m;
		for (int i = 0; i < l; i++) {
			ans = (ans % m + ((word[i] - 'a' + 1) * pow[i]) % m ) % m;
		}
		System.out.println(ans % m);
	}
}