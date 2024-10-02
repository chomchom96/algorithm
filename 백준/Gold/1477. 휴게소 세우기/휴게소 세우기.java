import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(l);
        while (st.hasMoreTokens()) arr.add(Integer.parseInt(st.nextToken()));
        Collections.sort(arr);
        int start = 1;
        int end = l;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;
            for (int i = 0; i <= n; i++) {
                int dist = arr.get(i+1) - arr.get(i) - 1;
                count += dist / mid;
            }
            if (count > m) start = mid + 1;
            else end = mid - 1;
        }
        System.out.println(start);
    }

}