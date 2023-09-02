import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int result;
    static int upperLimit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        upperLimit = (1 << N) - 1; // 모든 열을 표현하는 비트

        nqueen(0, 0, 0, 0);
        System.out.println(result);
    }

    static void nqueen(int row, int ld, int rd, int col) {
        if (row == upperLimit) {
            result++;
            return;
        }

        int pos = upperLimit & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & -pos; // 가장 오른쪽 1 비트를 찾음
            pos -= p;
            int colIdx = Integer.numberOfTrailingZeros(p);

            if ((col & (1 << colIdx)) == 0) {
                nqueen(row | p, (ld | p) << 1, (rd | p) >> 1, col | (1 << colIdx));
            }
        }
    }
}