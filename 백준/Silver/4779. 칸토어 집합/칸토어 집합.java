import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
		while ((str = br.readLine()) != null) {
			int i = Integer.parseInt(str);
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < Math.pow(3, i); j++) {
				String tri = Integer.toString(j,3);
				if (!tri.contains("1")) {
					sb.append('-');
				} else sb.append(' ');
			}	
			System.out.println(sb);
		}
	}
}