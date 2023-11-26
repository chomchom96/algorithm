import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long score = Long.parseLong(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        int answer = 1;

        if (n == 0) {
            System.out.println(1);
            System.exit(0);
        }
       
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[p];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int cnt2 = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] > score) {
                cnt++;
            } else if (arr[i] == score) {
                cnt2++;
            }
        }

        if (cnt + cnt2 >= p) {
            answer = -1;
        }
        else {
            answer = cnt+1;
        }
                        
            
            
            System.out.println(answer);
                
        }
}