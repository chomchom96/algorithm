import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Circle> circles = new ArrayList<>();
    static ArrayList<Integer>[] map;
    static boolean[] visit;

    static class Circle {
        int x, y, r;

        public Circle(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Circle empty1 = new Circle(0, 0, 2000001);
        circles.add(empty1);

        N = Integer.parseInt(br.readLine());
        map = new ArrayList[10000];
        visit = new boolean[10000];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            circles.add(new Circle(x, y, r));
        }

        Collections.sort(circles, (a, b) -> Integer.compare(a.r, b.r));

        for (int i = 0; i < 10000; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < circles.size(); i++) if (map[i].isEmpty()) connect(i);

        int ans = 0;

        for (int i = 0; i < circles.size(); i++) ans = Math.max(ans, dfs(i, 0));
        
        System.out.println(ans);
    }

    static boolean 겹침(Circle c1, Circle c2) {

        double x1 = c1.x;
        double y1 = c1.y;
        double r1 = c1.r;
        double x2 = c2.x;
        double y2 = c2.y;
        double r2 = c2.r;

        double pow1 = Math.pow(x2 - x1, 2);
        double pow2 = Math.pow(y2 - y1, 2);
        double d = Math.sqrt(pow1 + pow2);

        if (r2 + r1 < d) return false; // 중심이 멀리 떨어짐
        return true;
    }

    static void connect(int x) {
        int i = x + 1;
        boolean end = false;
        while (i < circles.size()) {
            if (겹침(circles.get(x), circles.get(i))) {
                if (!map[i].isEmpty()) end = true;

                map[x].add(i);
                map[i].add(x);
                x = i;
            }
            if (end)
                return;
            i++;
        }
    }

    static int dfs(int x, int depth) {
        if (visit[x])
            return 0;

        visit[x] = true;
        int cnt = depth;

        for (int i = 0; i < map[x].size(); i++) {
            int nx = map[x].get(i);
            depth = Math.max(depth, dfs(nx, cnt + 1));
        }

        visit[x] = false;
        return depth;
    }
}