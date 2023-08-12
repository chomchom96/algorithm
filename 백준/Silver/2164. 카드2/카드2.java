import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(findLastCard(N));
        br.close();
    }

    public static int findLastCard(int N) {
        int M = (int) Math.pow(2, (int) (Math.log(N) / Math.log(2)));
        int lastCard = 2 * (N - M);
        return (lastCard != 0) ? lastCard : N;
    }
}