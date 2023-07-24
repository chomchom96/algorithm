import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int ans = 0;
        int temp = 0;
        boolean flag = true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                c -= '0';
                temp = temp * 10 + c;
            }
            if (c == '+' || c == '-') {
                if (flag) {
                    ans += temp;
                    temp = 0;
                } else {
                    ans -= temp;
                    temp = 0;
                }
                if (c == '-') {
                    flag = false;
                }
            }
        }

        if (flag) {
            ans += temp;
        } else {
            ans -= temp;
        }

        System.out.print(ans);
    }
}
