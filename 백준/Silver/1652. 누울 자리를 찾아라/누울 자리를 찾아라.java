import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Character[][] map = new Character[N][N];
        for (int i = 0; i < N; i++) {
            char[] st = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) map[i][j] = st[j];
        }
        int rowCnt = 0, colCnt = 0;
        for (int i = 0; i < N; i++) {
            boolean newPlace = true;
            int rowTmp = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') rowTmp++;
                else {
                    newPlace = true;
                    rowTmp = 0;
                }
                if (rowTmp > 1 && newPlace) {
                    rowCnt++; newPlace = false;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            boolean newPlace = true;
            int colTmp = 0;
            for (int j = 0; j < N; j++) {
                if (map[j][i] == '.') colTmp++;
                else {
                    newPlace = true;
                    colTmp = 0;
                }
                if (colTmp > 1 && newPlace) {
                    colCnt++; newPlace = false;
                }
            }
        }
        System.out.println(rowCnt + " " + colCnt);
    }
}