import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);

        List<List<Long>> li = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            long a = Long.parseLong(input[0]);
            long b = Long.parseLong(input[1]);
            List<Long> pair = new ArrayList<>();
            pair.add(a);
            pair.add(b);
            li.add(pair);
        }

        li.sort(Comparator.comparing((List<Long> x) -> x.get(1)).thenComparing(x -> x.get(0)));

        long totalSum = 0;
        long day = T - N;

        for (List<Long> pair : li) {
            long a = pair.get(0);
            long b = pair.get(1);
            totalSum += a + b * day;
            day += 1;
        }

        System.out.println(totalSum);
    }
}
