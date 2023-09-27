import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		while (T --> 0) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<>();
			while (N --> 0) set.add(br.readLine());
			System.out.println(set.size());
		}
	}
}