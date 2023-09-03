import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] info = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) info[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(info);

        int left = 0;
        int right = n - 1;
        int minAbsSum = Integer.MAX_VALUE;
        int result1 = 0;
        int result2 = 0;

        while (left < right) {
            int sum = info[left] + info[right];
            int absSum = Math.abs(sum);

            if (absSum < minAbsSum) {
                minAbsSum = absSum;
                result1 = info[left];
                result2 = info[right];
            }

            if (sum < 0) left++;
            else right--;

            if (minAbsSum == 0) break;
        }

        System.out.println(result1 + " " + result2);
    }
}
