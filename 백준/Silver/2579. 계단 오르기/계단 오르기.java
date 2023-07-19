import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int stair[] = new int[t];
        for (int i = 0; i < t; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        int DP[] = new int[t];
        int ans = 0;
        if (t <= 2) {
            for (int i = 0; i < t; i++) {
                ans += stair[i];
            }
        } else {
            DP[0] = stair[0];
            DP[1] = stair[0] + stair[1];
            DP[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);
            for (int i = 3; i < t; i++) {
                DP[i] = Math.max(DP[i-3]+stair[i-1]+stair[i], DP[i-2]+stair[i]);
            }
            ans = DP[t-1];
        }
        System.out.println(ans);
    }
}