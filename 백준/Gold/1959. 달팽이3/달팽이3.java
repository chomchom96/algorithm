import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long m = sc.nextInt();
		long n = sc.nextInt();
		if (m > n) {
			if (n % 2 == 0) {
				long round = n/2 - 1;
				System.out.println(4 * round + 3);
				System.out.println((round + 2) + " " + (round + 1));
			}
			else {
				long round = n/2;
				System.out.println(4 * round + 1);
				System.out.println((m - round) + " " + (round + 1));
			}
		}
		else {
			if (m % 2 == 0) {
				long round = m/2 - 1;
				System.out.println(4 * round + 2);
				System.out.println((m - round) + " " + (round + 1));
			}
			else {
				long round = m/2;
				System.out.println(4 * round);
				System.out.println((round + 1) + " " + (n - round));
			}
			
		}
	}
}