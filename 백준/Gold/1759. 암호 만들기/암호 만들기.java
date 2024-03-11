import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int l, c;
    static Set<Character> s = new HashSet<>();
    static Set<String> ans = new TreeSet<>();
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        s.add('a'); s.add('e');s.add('i');s.add('o');s.add('u');
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = br.readLine().split(" ");
        Arrays.sort(arr);
        backtrack(0, 0, "");
        for (String str : ans) sb.append(str + "\n");

        System.out.println(sb);

    }

    private static void backtrack(int idx, int length, String str) {
        if (length == l) {
            int moeum = 0;
            int jaeum = 0;
            for (char c: str.toCharArray()) {
                if (s.contains(c)) {
                    moeum++;
                }
                else jaeum++;
            }
//            if (flag) sb.append(str).append("\n");
            if (moeum>=1 && jaeum>=2) ans.add(str);
        }
        if (idx == c) return;
        backtrack(idx+1, length+1, str+arr[idx]);
        backtrack(idx+1, length, str);

    }

}