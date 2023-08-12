import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] num;
    static int N, S, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        num = new int[N];
        String[] numInput = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(numInput[i]);
        }

        partial_sum(0, 0);
        if (S == 0)
            System.out.println(answer - 1);
        else
            System.out.println(answer);
    }

    static void partial_sum(int depth, int cur_sum) {
        if (depth == N) {
            if (cur_sum == S)
                answer++;
            return;
        }
        partial_sum(depth + 1, cur_sum + num[depth]);
        partial_sum(depth + 1, cur_sum);
    }
}
