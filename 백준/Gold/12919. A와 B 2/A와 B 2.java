import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S;
    static int a_count,b_count;
    static boolean isPossible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        String T = br.readLine();
        int s_a = 0, s_b = 0, t_a = 0, t_b = 0;
        for (char c : S.toCharArray()) {
            if (c == 'A') s_a++;
            else s_b++;
        }
        for (char c : T.toCharArray()) {
            if (c == 'A') t_a++;
            else t_b++;
        }
        a_count = t_a - s_a;
        b_count = t_b - s_b;
        dfs(0, 0, T);

        System.out.println(isPossible? 1: 0);
    }

    private static void dfs(int a_sum, int b_sum, String str) {
        if (str.equals(S)) isPossible = true;
        if (isPossible) return;
        if (a_sum < a_count && str.charAt(str.length()-1) == 'A') {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            dfs(a_sum+1, b_sum, sb.deleteCharAt(sb.length()-1).toString());
        }

        if (b_sum < b_count && str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            dfs(a_sum, b_sum+1, sb.deleteCharAt(0).reverse().toString());
        }
    }
}