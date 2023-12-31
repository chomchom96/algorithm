import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] fibo = new long[80];
        fibo[1] = fibo[2] = 1;
        for (int i = 3; i < 80; i++) fibo[i] = fibo[i - 1] + fibo[i - 2];
        long N = Long.parseLong(br.readLine());
        while (true) {
            long temp = N; 
            for (int i = 1; i < 80; i++) {
                if (temp < fibo[i]) {
                    temp = fibo[i - 1];
                    break;
                }
            }
            if (temp == N) break;
            N -= temp;
        }
        System.out.println(N);
    }
}