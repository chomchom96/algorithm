import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        int[] DP = new int[11];
        DP[0] = 1;
        DP[1] = 2;
        DP[2] = 4;
        DP[3] = 7;
        for (int i = 4; i < 11; i++) {
            DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
        }
        for (int i = 0; i < test_case; i++) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(DP[k - 1]);
        }
    }
}
