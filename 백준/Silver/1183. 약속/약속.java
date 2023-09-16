import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            numbers.add(b - a);
        }

        Collections.sort(numbers);

        int answer = 0;
        if (numbers.size() % 2 == 0) {
            int start = numbers.size() / 2 - 1;
            answer = numbers.get(start + 1) - numbers.get(start) + 1;
        } else {
            answer = 1;
        }

        System.out.println(answer);
    }
}
