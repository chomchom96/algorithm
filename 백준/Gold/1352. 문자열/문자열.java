import java.util.Scanner;

public class Main {
    static int[] alpha = new int[27]; // 'A'의 맨 처음 등장 위치는 alpha[1].
    static char[] result = new char[101];
    static int[] ans = new int[27];
    static int num;
    static boolean check = false;

    static void back(int len, int pos, int sum) {
        if (len + 1 == pos) {
            if (sum == num) {
                check = true;
                System.arraycopy(alpha, 0, ans, 0, alpha.length);
            }
        } else {
            for (int i = alpha[pos - 1] + 1; i <= sum + 1; i++) {
                if (sum + i > num) break;
                alpha[pos] = i;
                back(len, pos + 1, sum + i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        sc.close();

        for (int i = 1; i < 18; i++) {
            back(i, 1, 0);

            if (check == true) {
                for (int j = 1; j <= i; j++) {
                    result[ans[j]] = (char) ('A' + j - 1);
                }

                int cnt = 1;
                for (int j = 1; j <= i; j++) {
                    while (ans[j] != 1) {
                        if (result[cnt] == 0) {
                            result[cnt] = (char) ('A' + j - 1);
                            ans[j]--;
                            cnt++;
                        } else cnt++;
                    }
                }
                for (int j = 1; j <= num; j++) System.out.print(result[j]);
                System.exit(0);
            }
        }
        System.out.print("-1");
    }
}