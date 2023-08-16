import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			String find = sc.next();
			String string = sc.next();
			int cnt = 0;
			for (int i = 0; i < string.length() - find.length() + 1; i++) {
				if (string.charAt(i) == find.charAt(0)) {
					boolean flag = true;
					for (int j = 1; j < find.length(); j++){
						if (string.charAt(i + j) != find.charAt(j)) flag = false; 
					}
					if (flag) cnt++;
				}
			}
			System.out.println("#" + tc + " " +cnt);
		}
	}
}