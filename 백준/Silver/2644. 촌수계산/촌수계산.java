import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] map;
    static boolean[] visited;
    static  boolean flag =false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) map[i] = new ArrayList<Integer>();
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        while (M --> 0) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            map[parent].add(child);
            map[child].add(parent);
        }
        // 쉬운 거니까 parent -> child dfs만 해도 되긴헤
        dfs(start, end, 0);
        if (!flag) System.out.println(-1);
    }

    static void dfs(int start, int end, int cnt) {
        visited[start] = true;
        if (start == end) {
            System.out.println(cnt); flag = true;
            return;
        }
        for (int next : map[start]) {
            if (!visited[next]) dfs(next, end, cnt+1);
        }
        visited[start] = false;

    }
}
