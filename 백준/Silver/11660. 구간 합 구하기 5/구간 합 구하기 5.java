import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> l = new ArrayList<>();
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                l.add(Integer.parseInt(st2.nextToken()));
            }
            list.add(l);
        }
        List<List<Integer>> DP = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> dpRow = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    dpRow.add(list.get(i).get(j));
                } else if (i == 0) {
                    dpRow.add(dpRow.get(j - 1) + list.get(i).get(j));
                } else if (j == 0) {
                    dpRow.add(DP.get(i - 1).get(j) + list.get(i).get(j));
                } else {
                    dpRow.add(DP.get(i - 1).get(j) + dpRow.get(j - 1) - DP.get(i - 1).get(j - 1) + list.get(i).get(j));
                }
            }
            DP.add(dpRow);
        }
        
        for (int i = 0; i < M; i++) {
        	StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
        	int sy = Integer.parseInt(st3.nextToken());
        	int sx = Integer.parseInt(st3.nextToken());
        	int ey = Integer.parseInt(st3.nextToken());
        	int ex = Integer.parseInt(st3.nextToken());
        	System.out.println(calculatePartialSum(DP,sy-1,sx-1,ey-1,ex-1));

        }
    }
    
    private static int calculatePartialSum(List<List<Integer>> DP, int sy, int sx, int ey, int ex) {
        if (sy == 0 && sx == 0) {
            return DP.get(ey).get(ex);
        } else if (sy == 0) {
            return DP.get(ey).get(ex) - DP.get(ey).get(sx - 1);
        } else if (sx == 0) {
            return DP.get(ey).get(ex) - DP.get(sy - 1).get(ex);
        } else {
            return DP.get(ey).get(ex) - DP.get(ey).get(sx - 1) - DP.get(sy - 1).get(ex) + DP.get(sy - 1).get(sx - 1);
        }
    }

}