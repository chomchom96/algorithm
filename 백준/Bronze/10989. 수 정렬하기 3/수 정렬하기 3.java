import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for (int i = 0; i < N; i++) arr[Integer.parseInt(br.readLine())]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10001; i++) {
        	int count = arr[i];
        	while (count --> 0) sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}