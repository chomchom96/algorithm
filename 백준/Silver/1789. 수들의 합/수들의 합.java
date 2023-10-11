import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println((int) (Math.sqrt(n * 2 + 0.25) - 0.5));
    }
}