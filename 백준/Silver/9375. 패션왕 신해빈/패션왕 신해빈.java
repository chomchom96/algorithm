import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-->0) {
			int te = sc.nextInt();
			Map<String, List<String>> m = new HashMap<>();

			while (te-->0) {
				String val = sc.next();
				String key = sc.next();
				if (!m.containsKey(key)) {
				    m.put(key, new ArrayList<>());
				}
				m.get(key).add(val);
			}
			int ans = 1;
			for (String key : m.keySet()) {
				List<String> values = m.get(key);
				ans *= values.size() + 1;
			}
			System.out.println(ans - 1);
		}
	}
}