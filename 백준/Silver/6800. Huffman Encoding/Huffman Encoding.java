import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        String[] tree = new String[2097152];
        Arrays.fill(tree, " ");
        while (k --> 0) {
        	st = new StringTokenizer(br.readLine());
        	String word = st.nextToken();
        	String code = st.nextToken();
        	int idx = 1;
        	for (int i = 0; i < code.length(); i++) {
        		if (code.charAt(i) == '0') idx *= 2;
        		else idx = idx * 2 + 1;
        	}
        	tree[idx] = word;
        }
        String code = br.readLine();
//        for (int i = 0; i < 10; i++) System.out.print(tree[i]);
        int idx = 1;
        String ans = "";
        for (int i = 0; i < code.length(); i++) {
        	if (code.charAt(i) == '0') idx *= 2;
        	else idx = idx * 2 + 1;
        	if (!tree[idx].equals(" ")) {
        		ans += tree[idx];
        		idx = 1;
        	}
        }  
        System.out.println(ans);
    }

}