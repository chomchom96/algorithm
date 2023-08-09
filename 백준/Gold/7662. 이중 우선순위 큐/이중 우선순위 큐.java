import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		while(tc-->0) {
			int n = Integer.parseInt(br.readLine());
			while (n-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if (cmd == 'I') {
					tm.put(num, tm.getOrDefault(num, 0) + 1);
				}
				else if (cmd == 'D'){
					 if (tm.isEmpty()) continue;
					 else {
	                    int key =num== 1? tm.lastKey() : tm.firstKey();
	                    int val = tm.get(key);
	                    if (val == 1) {
	                    	tm.remove(key);
	                    }
	                    else {
	                    	tm.put(key,  val - 1);
	                    }
					 }
				}
				
			}
			if (tm.size() == 0) System.out.println("EMPTY");
			else System.out.println(tm.lastKey() + " " + tm.firstKey());
			tm.clear();
		}
	}
}