import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		HashMap<String, String> sitepw = new HashMap<String, String>();
		for (int i = 0; i < N; i++) {
			String in[] = br.readLine().split(" ");
			sitepw.put(in[0], in[1]);
		}		
		for (int i=0; i< M; i++) {
			String key = br.readLine();
			System.out.println(sitepw.get(key));
		}
	}
}