import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static StringTokenizer st;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int TC = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	while (TC --> 0) {
    		String[] howling = br.readLine().split(" ");
    		HashSet<String> notFox = new HashSet<>();
    		while (true) {
    			String input = br.readLine();
    			String[] gaesori = input.split(" ");
    			
    			if (gaesori.length != 3) break;
    			notFox.add(gaesori[2]);
    		}
    		for (String howl : howling) {
    			if (!notFox.contains(howl)) sb.append(howl + " ");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb);
    }
}