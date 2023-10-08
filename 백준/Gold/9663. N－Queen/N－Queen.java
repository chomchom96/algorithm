import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] board;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];
        visited = new boolean[N];
        result = 0;

        nqueen(0);
        System.out.println(result);
    }

    static void nqueen(int depth) {
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                board[depth] = i;

                if (check(depth)) {
                    visited[i] = true;
                    nqueen(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (board[n] == board[i] || n - i == Math.abs(board[n] - board[i])) {
                return false;
            }
        }
        return true;
    }
}