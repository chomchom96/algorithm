import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        board = new char[N][2 * N - 1];
        for (char[] row : board) Arrays.fill(row, ' ');

        drawStar(0, N - 1, N);

        for (char[] row : board) System.out.println(row);
    }

    public static void drawStar(int r, int c, int size) {
        if (size == 3) {
            board[r][c] = board[r + 1][c - 1] = board[r + 1][c + 1] = '*';
            for (int i = -2; i <= 2; i++) board[r + 2][c + i] = '*';
        } else {
            size /= 2;
            drawStar(r, c, size);
            drawStar(r + size, c - size, size);
            drawStar(r + size, c + size, size);
        }
    }
}