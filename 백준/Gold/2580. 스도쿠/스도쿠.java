import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
	static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < 9; j++) sudoku[i][j] = Integer.parseInt(st.nextToken());
        }
        fill(0,0);               
    }
    
    static void fill(int i, int j) {
    	if (j == 9)  {
    		fill(i +1, 0); return;
    	}
    	if (i == 9) {
    		StringBuilder sb = new StringBuilder();
    		for (int r = 0; r < 9; r++) {
    			for (int c = 0; c < 9; c++) sb.append(sudoku[r][c]).append(' ');
    			sb.append('\n');
    		}
    		System.out.println(sb); System.exit(0);
    	}
    	if (sudoku[i][j] == 0) {
    		for (int val = 1; val <= 9; val++) {
    			if (check(i, j, val)) {
    				sudoku[i][j] = val; fill(i, j+ 1);
    			}
    		}
    		sudoku[i][j] = 0; return;
    	}
    	fill(i, j + 1);
    }
    
    static boolean check(int row, int col, int value) {
    	for (int i = 0; i < 9; i++ ) if (sudoku[row][i] == value || sudoku[i][col] == value) return false;
    	for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) if (sudoku[row/3 * 3 + i][col/3 * 3 + j] == value) return false;
    	return true;
    }
}