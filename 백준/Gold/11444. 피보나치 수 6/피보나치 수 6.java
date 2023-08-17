import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long a;
    final static long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long A = Long.parseLong(br.readLine());
        br.close();
        
        if (A == 1 || A == 0) {
        	System.out.println(A);
        	System.exit(0);
        }
        A--;
        long[][] fibo = {{1, 1},{1, 0}};
        long[][] origin = {{1, 0},{0, 1}};
        
        while (A > 0) { // 분할으로 제곱
        	if(A % 2 == 1) {
				origin = multiply_matrix(fibo, origin);
			}
			fibo = multiply_matrix(fibo, fibo);
			
			A /= 2;
        }
        
        System.out.println(origin[0][0]);
    }
    
    static long[][] multiply_matrix(long[][] a, long[][] b){
    	long[][] result = new long[2][2];
    	result[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0]) % MOD;
    	result[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1]) % MOD;
    	result[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0]) % MOD;
    	result[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1]) % MOD;
    	return result;
    }
}