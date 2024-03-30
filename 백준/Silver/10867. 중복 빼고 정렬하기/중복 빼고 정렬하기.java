import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> hashSet = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();

        for (int val : hashSet) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }
}