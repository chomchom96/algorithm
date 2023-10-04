import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// KMP
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        int[] arr = new int[P.length()];
        // 파이 배열 구하기
        int idx = 0;
		for (int i = 1; i < P.length(); i++) {
			while (idx > 0 && P.charAt(i) != P.charAt(idx)) idx = arr[idx - 1];

			if (P.charAt(i) == P.charAt(idx)) arr[i] = ++idx;
		}
		
        StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		idx = 0;
		for (int i = 0; i < T.length(); i++) {
			while (idx > 0 && P.charAt(idx) != T.charAt(i)) idx = arr[idx - 1];
			
			if (P.charAt(idx) == T.charAt(i)) {
				if (idx + 1 == P.length()) {
					list.add(i + 1 - idx);
					idx = arr[idx];
				} 
				else idx++;
			}
			
		}
		
		sb.append(list.size() + "\n");
		
		for (Integer i : list) sb.append(i + "\n");
		
		System.out.print(sb);
		
    }
}