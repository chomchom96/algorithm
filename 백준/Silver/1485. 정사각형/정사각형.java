import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static boolean valid(int[][] points) {
        int[] dist = new int[6];
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                dist[idx++] = dist(points[i], points[j]);
            }
        }

        Arrays.sort(dist);

        if (dist[0] == dist[1] && dist[0] == dist[2] && dist[0] == dist[3] &&
                dist[4] == dist[5] && 2 * dist[0] == dist[4]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[][] points = new int[4][2];
            for (int i = 0; i < 4; i++) {
                String[] input = br.readLine().split(" ");
                points[i][0] = Integer.parseInt(input[0]);
                points[i][1] = Integer.parseInt(input[1]);
            }

            if (valid(points)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
