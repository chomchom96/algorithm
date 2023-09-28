import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] sieve = new boolean[1000002];

        int m = (int) Math.sqrt(1000001);
        for (int i = 2; i <= m; i++) if (!sieve[i])  for (int k = i + i; k <= 1000001; k += i)  sieve[k] = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            for (int i = 2; i < n; i++) if (!sieve[i]) if (!sieve[n - i]) {
                    sb.append(n + " = " + i + " + " + (n - i) + "\n"); break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
