import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static String target;
  static int d;
  static long x, y;
  static long xcoord = 0;
  static long ycoord = 0;
  static StringBuilder sb = new StringBuilder();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    d = Integer.parseInt(st.nextToken());
    target = st.nextToken();
    
    st = new StringTokenizer(br.readLine());
    y = Long.parseLong(st.nextToken());
    x = Long.parseLong(st.nextToken());
    
    long n = 1L << d;
    search(0, 0, 0, n, n);
    xcoord -= x;
    ycoord += y;
    
    if(0 <= xcoord && xcoord < n && 0 <= ycoord && ycoord < n) {
      check(d, xcoord, ycoord);
      System.out.println(sb);
    }
    else System.out.println(-1);
    
  }
  public static void check(int length, long tx, long ty) {
    if( length == 0) {
      return;
    }
    
    long half = 1L << (length - 1);

    if(tx < half && ty >= half) {
      sb.append("1");
      check(length-1, tx, ty-half);
    }
    else if(tx < half && ty < half) {
      sb.append("2");
      check(length-1, tx, ty);
    }
    else if(tx >= half && ty < half) {
      sb.append("3");
      check(length-1, tx-half, ty);
    }
    else if(tx >= half && ty >= half) {
      sb.append("4");
      check(length-1, tx-half, ty-half);
    }
  }
  public static void search(int index, long lx, long ly, long rx, long ry) {
    if(index == d) {
      xcoord = lx;
      ycoord = ly;
      return;
    }

    int num = target.charAt(index) - '0';

    if(num == 1) {
      search(index+1,lx,(ly+ ry)/2,(lx + rx) /2, ry);
    }
    else if(num == 2) {
      search(index+1,lx,ly,(lx + rx)/2 , (ly + ry) / 2);
    }
    else if(num == 3) {
      search(index+1,(lx+rx)/2,ly,rx , (ly + ry) / 2);
    }
    else if(num == 4) {
      search(index+1,(lx+rx)/2,(ly + ry) / 2, rx , ry);
    }
    
  }
}
