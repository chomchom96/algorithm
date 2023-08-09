import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
   
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		List<Integer> l = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) {
			int subsum = 0;
			if (s.charAt(i) == 'I') {
				subsum++;
				while (true) {
					if (i < s.length() -2) {
						if (s.substring(i + 1, i + 3).equals("OI")) {
							subsum++;
							i += 2;
						} else break;
					}
					else break;
				}
				l.add(subsum);
			}
		}
		int ans = 0;
		for (int i : l) {
			ans += Math.max(0, i - n);
		}
		System.out.println(ans);
	}
}