import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Long, Long> map = new HashMap<>();
    static long n, p, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        map.put(0L, 1L);
        map.put(1L, 2L);
        for (long i = 2; i < 10; i++) {
            map.put(i,  map.get(i/p) + map.get(i/q));
        }
        long ans = DPthingy(n);
        System.out.println(ans);
    }

    static long DPthingy(long n) {
        if (map.get(n) != null) return map.get(n);
        else {
            long h = (long)Math.floor(n/p);
            long t = (long)Math.floor(n/q);
            map.put(n, DPthingy(h) + DPthingy(t));
            return map.get(n);
        }
    }
}