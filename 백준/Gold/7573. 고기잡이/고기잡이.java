import java.io.*;
import java.util.*;

class Position {
    int x, y;
    
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m, l, res = 0;
    static ArrayList<Position> arr;
    
    static void calc(int x, int y, int width, int height) {
        int cnt = 0;
        for(int i = 0; i < m; i++) {
            if(x <= arr.get(i).x && arr.get(i).x <= x + width && 
               y <= arr.get(i).y && arr.get(i).y <= y + height) {
                cnt++;
            }
            res = Math.max(res, cnt);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Position(x, y));
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                for(int k = 1; k < l/2; k++) {
                    calc(arr.get(i).x, arr.get(j).y, k, l/2-k);
                }
            }
        }
        
        System.out.println(res);
    }
}