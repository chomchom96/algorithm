import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        backTrack(1, 0);
        System.out.println(sb);
    }

    static void backTrack(int start, int depth) {
        if (depth == m) { for (int i = 0; i < m; i++) sb.append(arr[i] + " ");
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            arr[depth] = i;
            backTrack(i, depth + 1);
        }
    }
}