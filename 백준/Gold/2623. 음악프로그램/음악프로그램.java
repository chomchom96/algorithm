import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] list;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<Integer>();

        inDegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int head = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt - 1; j++) {
                int tail = Integer.parseInt(st.nextToken());
                inDegree[tail]++; 
                list[head].add(tail);
                head = tail;
            }
        }

        ArrayList<Integer> sorted = tSort(n);
        
        if (sorted.size() == n) for (int node : sorted) System.out.println(node);   
        else System.out.println("0");
    }

    public static ArrayList<Integer> tSort(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        ArrayList<Integer> sorted = new ArrayList<>();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sorted.add(cur);

            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.offer(next);
            }
        }
        return sorted;
    }
}