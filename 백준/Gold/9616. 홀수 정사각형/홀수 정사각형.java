import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
        	st = new StringTokenizer(br.readLine());
            long m = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            
            if (m == 0 && n == 0) {
                break;
            }
            
            long ans = 0;
            for (long i = 1; i <= Math.min(m, n); i += 2) {
                ans += (m - i + 1) * (n - i + 1) * i;
            }
            
            System.out.println(ans);
        }
        
    }
}