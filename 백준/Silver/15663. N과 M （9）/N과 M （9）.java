import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr2;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> arr;
	static Set<ArrayList<Integer>> set = new HashSet<>();
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList<>();
        arr2 = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr2[i] = Integer.parseInt(st2.nextToken());
        Arrays.sort(arr2);
        visited = new boolean[n];
        
        backTrack(0);
        System.out.println(sb);
    }
    
    
    static void backTrack(int depth) {
    	if (depth == m) {
    		if (!set.contains(arr)) {
    			set.add(arr);
	    		for (int a : arr) {
	    			sb.append(a).append(' ');
	    		}
	    		sb.append('\n');

	    		return;
    		}
    	}
    	
    	for (int i = 0; i < n; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			arr.add(arr2[i]);
    			backTrack(depth + 1);
    			visited[i] = false;
    			if (!arr.isEmpty()) arr.remove(arr.size() - 1);
    		}
    	}
    }
}