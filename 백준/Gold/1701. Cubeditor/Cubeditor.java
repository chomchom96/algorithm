import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int ans, k;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		k = word.length();
		ans = 0;
		for (int i = 0; i < k ; i++) 
			KMP(word.substring(i, k));
		
		System.out.println(ans);
	}
	
	static void KMP(String word) {
		
		int[] arr = new int[k];
		int idx = 0;
		for (int i = 1; i < word.length(); i++) {
			while (idx > 0 && word.charAt(idx) != word.charAt(i)) idx = arr[idx - 1];
			if (word.charAt(i) == word.charAt(idx)) arr[i] = ++idx;
			ans = Math.max(arr[i], ans);
		}
//		System.out.println(Arrays.toString(arr));
	}
}