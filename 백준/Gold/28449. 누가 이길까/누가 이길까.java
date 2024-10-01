import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] hi = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        long hi_win = 0L, arc_win = 0L, draw = 0L;

        for (int i = 0; i < n; i++) {
            int s = 0;
            int e = m - 1;
            int target = hi[i];
            int left_idx = m;

            while (s <= e) {
                int mid = (s + e) / 2;
                if (arc[mid] >= target) {
                    left_idx = mid;
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }

            int right_idx = -1;
            s = 0;
            e = m - 1;

            while (s <= e) {
                int mid = (s + e) / 2;
                if (arc[mid] <= target) {
                    right_idx = mid;
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }

            hi_win += left_idx;
            draw += (right_idx - left_idx + 1);
            arc_win += (m - right_idx - 1);
        }

        System.out.println(hi_win + " " + arc_win + " " + draw);
    }

}