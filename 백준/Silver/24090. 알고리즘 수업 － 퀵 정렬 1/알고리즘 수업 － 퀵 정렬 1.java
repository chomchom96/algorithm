import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k, cnt;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[n];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        quickSort(0, nums.length - 1);

        if (k > cnt) {
            System.out.println(-1);
        }
    }

    static int partition(int p, int r) {
        int pivot = nums[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(i, j);
                cnt++;
                if (cnt == k) {
                    printResult(i, j);
                }
            }
        }

        if (i + 1 != r) {
            swap(i + 1, r);
            cnt++;
            if (cnt == k) {
                printResult(i + 1, r);
            }
        }

        return i + 1;
    }

    static void quickSort(int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(p, r);
        quickSort(p, q - 1);
        quickSort(q + 1, r);
    }

    static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void printResult(int i, int j) {
        if (nums[i] <= nums[j]) {
            System.out.println(nums[i] + " " + nums[j]);
        } else {
            System.out.println(nums[j] + " " + nums[i]);
        }
        System.exit(0);
    }
}
