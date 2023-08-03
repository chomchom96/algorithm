import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, plus, minus, mul, div, num;
	static int max_val = Integer.MIN_VALUE; static int min_val = Integer.MAX_VALUE;
	static List<Integer> array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		List<Integer> array = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) array.add(Integer.parseInt(st.nextToken()));
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		plus = Integer.parseInt(st2.nextToken());
		minus = Integer.parseInt(st2.nextToken());
		mul = Integer.parseInt(st2.nextToken());
		div = Integer.parseInt(st2.nextToken());
		
		backtrack(plus, minus, mul, div, array.get(0), 1, array);
		System.out.println(max_val);
		System.out.println(min_val);
	}
	
	static void backtrack(int plus, int minus, int mul, int div, int num, int cnt, List<Integer> array) {
		if (cnt == n) {
	        max_val = Math.max(max_val, num);
	        min_val = Math.min(min_val, num);
	        return;
	    }

	    if (plus > 0)
	        backtrack(plus - 1, minus, mul, div, num + array.get(cnt), cnt + 1, array);
	    if (minus > 0)
	        backtrack(plus, minus - 1, mul, div, num - array.get(cnt), cnt + 1, array);
	    if (mul > 0)
	        backtrack(plus, minus, mul - 1, div, num * array.get(cnt), cnt + 1, array);
	    if (div > 0)
	        backtrack(plus, minus, mul, div - 1, num / array.get(cnt), cnt + 1, array);
	}
}