import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i =0; i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

		int left = 0;
		int right = 0;
		int sum = 0;
		int answer = Integer.MAX_VALUE;
		while (left <=N && right <=N) {
			if(sum >= S && answer > right-left) {
				sum -= arr[left];
				answer = right-left;
				left++;
		
			}
			if(sum < S){
				sum += arr[right++];
			}
			else {
				sum-= arr[left++];
			}
		}
		System.out.println(answer == Integer.MAX_VALUE? 0: answer);
	}

}