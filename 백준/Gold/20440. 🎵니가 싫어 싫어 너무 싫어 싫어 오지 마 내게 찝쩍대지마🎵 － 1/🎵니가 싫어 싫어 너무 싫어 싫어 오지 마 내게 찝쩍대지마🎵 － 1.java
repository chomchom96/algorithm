import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int stMogi = map.getOrDefault(start, 0);
        	map.put(start, stMogi + 1);
        	int endMogi = map.getOrDefault(end, 0);
        	map.put(end, endMogi - 1);
        }
        
//        System.out.println(map);
        
        int max = 0;
        int curSum = 0;
        int startMax = 0;
        int endMax = 0;
        boolean flag = false;
        
        for (int key : map.keySet()) {
        	int cur = map.get(key);
        	curSum += cur;
        	if (cur > 0) {
        		if (curSum > max) {
        			max = curSum;
        			startMax = key;
        			flag = true;
        		}
        	}
        	
        	if (cur < 0 && flag) {
        		endMax = key;
        		flag = false;
        	}
        }
        StringBuilder sb = new StringBuilder();
        
        sb.append(max + "\n");
        sb.append(startMax + " " + endMax);
        System.out.println(sb);
    }
}