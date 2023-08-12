import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(findLastCard(N));
    }

    public static int findLastCard(int N) {
        int M = (int) Math.pow(2, (int) (Math.log(N) / Math.log(2)));
        int lastCard = 2 * (N - M);
        return (lastCard != 0) ? lastCard : N;
    }
}