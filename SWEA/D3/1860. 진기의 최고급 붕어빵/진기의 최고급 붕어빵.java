import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int test_case = 1; test_case <= t; test_case++) {
            int n = scanner.nextInt();
            int cost = scanner.nextInt();
            int value = scanner.nextInt();
            int[] customer = new int[n];
            for (int i = 0; i < n; i++) {
                customer[i] = scanner.nextInt();
            }

            Arrays.sort(customer);

            String result = "Possible";
            for (int i = 0; i < n; i++) {
                int c = customer[i];
                if ((c / cost) * value - i < 1) {
                    result = "Impossible";
                    break;
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}
