import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        String m = st.nextToken();
        
        int ans = 0;
        if (n.length() == m.length()) {
            for (int i = 0; i < n.length(); i++) {
                if (n.charAt(i) != m.charAt(i)) {
                    break;
                } else if (n.charAt(i) == '8') {
                	ans++;
                }
            }
        }    
        System.out.println(ans);
    }
}