import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long ans = 0L;
        while (N --> 0) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty()) {
                if (stack.peek() <= height) stack.pop();
                else break;
            }
            ans += stack.size();
            stack.add(height);
        }
        System.out.println(ans);
    }
}