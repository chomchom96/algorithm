import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<Integer> set, nextSet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        while (TC --> 0) {
            set = new HashSet<>();
            set.add(1);
            nextSet = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            while (N --> 0) {
                st = new StringTokenizer(br.readLine());
                String op1 = st.nextToken();
                int num1 = Integer.parseInt(st.nextToken());
                operate(op1, num1);
                String op2 = st.nextToken();
                int num2 = Integer.parseInt(st.nextToken());
                operate(op2, num2);
                set.clear();
                for (int n : nextSet) set.add(n);
                nextSet.clear();
            }
            System.out.println(set.contains(0)? "LUCKY" : "UNLUCKY");
        }
    }

    private static void operate(String op, int num) {
        if (op.equals("+")) for (int s :set) nextSet.add((s+num)%7);
        else for (int s : set) nextSet.add((s*num)%7);
    }

}
