import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] towers = new int[N][2];
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                answer.append("0 ");
                stack.push(i + 1);
            } else {
                while (!stack.isEmpty()) {
                    int topIndex = stack.peek();

                    if (towers[topIndex - 1][1] > height) {
                        answer.append(topIndex + " ");
                        stack.push(i + 1);
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (stack.isEmpty()) {
                    answer.append("0 ");
                    stack.push(i + 1);
                }
            }

            towers[i][0] = i + 1;
            towers[i][1] = height;
        }

        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}