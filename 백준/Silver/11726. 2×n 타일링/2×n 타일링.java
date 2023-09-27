import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] array = new int[1001];
        array[0] = 1;
        array[1] = 2;
        if (n <= 2) {
        	System.out.println(array[n-1]);
        } else {
        	for (int i = 2; i <= n; i++) {
        		array[i] = (array[i-1] + array[i-2]) % 10007;
        	}
        	System.out.println(array[n-1]);
        }
    }
}