import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static char[] susik;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        susik = br.readLine().toCharArray();
        solve(2, susik[0] - '0');
        System.out.println(max);
    }

    private static void solve(int i, int sum) {
        if (i >= N) {
            max = Math.max(max, sum);
            return;
        }

        solve(i+2, cal(sum, susik[i]-'0', susik[i-1]));

        if (i + 2< N) {
            int right = cal(susik[i]-'0', susik[i+2]-'0' , susik[i+1]);
            int left = cal(sum, right, susik[i-1]);
            solve(i+4, left);
        }
    }
    private static int cal(int i, int j, char op) {
        return switch (op) {
            case ('+') -> i + j;
            case ('-') -> i - j;
            case ('*') -> i * j;
            default -> 0;
        };
    }
}