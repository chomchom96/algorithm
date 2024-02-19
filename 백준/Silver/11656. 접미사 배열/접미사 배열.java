import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String string = br.readLine();
            Set<String> set = new TreeSet<>();
            int N = string.length();
            for (int i = 0; i < N; i++) {
                String suffix = string.substring(i, N);
                set.add(suffix);
            }
            for (String suffix : set) System.out.println(suffix);
    }
}