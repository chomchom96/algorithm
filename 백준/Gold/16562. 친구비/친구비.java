import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] price;
    static int[] parent;
    // 어려운 로직이 아니고모든 union의 최소 비용만 더해주기
    // union의 parent가 비용이 가장 낮은 친구가 되도록
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        // 친구비 입력
        price = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)  price[i] = Integer.parseInt(st.nextToken());
        // 친구관계 union
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        for (int i = 1; i <= N; i++) union(i, parent[i]);

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= N; i++) set.add(parent[i]);
        Iterator<Integer> setIterator = set.iterator();
        int sum = 0;
        while (setIterator.hasNext()) sum += price[setIterator.next()];
        if (sum <= k) System.out.println(sum);
        else System.out.println("Oh no");

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (price[a] < price[b]) parent[b] = a;
        else parent[a] = b;
    }

    static int find(int a) {
        if (parent[a] != a)
            return parent[a] = find(parent[a]);
        else return a;
    }

}