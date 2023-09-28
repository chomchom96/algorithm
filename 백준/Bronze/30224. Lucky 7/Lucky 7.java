import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        String input = br.readLine();
        if (input.contains("7"))
            ans += 2;
        if (Integer.parseInt(input) % 7 == 0)
            ans++;
        System.out.println(ans);
    }
}
