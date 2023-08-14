import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stream = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < stream.length(); i++) {
            stack.add(stream.charAt(i));

            if (stack.size() >= bomb.length() && stack.peek() == bomb.charAt(bomb.length() - 1)) {
                boolean isBombPattern = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isBombPattern = false;
                        break;
                    }
                }

                if (isBombPattern) {
                    for (int k = 0; k < bomb.length(); k++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char s : stack) sb.append(s);
        if (sb.length() > 0) System.out.println(sb);
        else System.out.println("FRULA");
    }
}