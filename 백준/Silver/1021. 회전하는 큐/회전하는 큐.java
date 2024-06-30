import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int ans = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = queue.indexOf(target);

            int leftMoves = index;
            int rightMoves = queue.size() - index;

            ans += Math.min(leftMoves, rightMoves);

            while (queue.peek() != target) {
                if (leftMoves <= rightMoves) {
                    queue.addLast(queue.pollFirst());
                } else {
                    queue.addFirst(queue.pollLast());
                }
            }
            queue.pollFirst();
        }
        System.out.println(ans);
    }
}
