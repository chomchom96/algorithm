import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < n; i++) {
        	sum += arr[i] * (n - i);
        }
        System.out.println(sum);
        
	}
}
