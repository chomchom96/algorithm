import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] li = new int[n + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            li[i] = Integer.parseInt(st.nextToken());
        }
        li[n] = 0;
        li[n + 1] = 0;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (li[i + 1] > li[i + 2]) {
                int a = Math.min(li[i], li[i + 1] - li[i + 2]);
                ans += 5 * a;
                li[i] -= a;
                li[i + 1] -= a;

                int b = Math.min(li[i], Math.min(li[i + 1], li[i + 2]));
                ans += 7 * b;
                li[i] -= b;
                li[i + 1] -= b;
                li[i + 2] -= b;
            } else {
                int b = Math.min(li[i], Math.min(li[i + 1], li[i + 2]));
                ans += 7 * b;
                li[i] -= b;
                li[i + 1] -= b;
                li[i + 2] -= b;

                int a = Math.min(li[i], li[i + 1]);
                ans += 5 * a;
                li[i] -= a;
                li[i + 1] -= a;
            }

            ans += 3 * li[i];
        }

        System.out.println(ans);
        br.close();
    }
}
