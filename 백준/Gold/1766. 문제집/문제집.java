import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int n;
	static List<Integer>[] graph;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] inDegree = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<Integer>();
        
        while (m --> 0) {
        	st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	inDegree[end]++;
        	graph[start].add(end);
        }
        
        List<Integer> ans = new ArrayList<>();
        TreeSet<Integer> queue = new TreeSet<>();
        
        for (int i = 1; i <= n; i++) if (inDegree[i] == 0) {
        	queue.add(i);
        }
        
        while (!queue.isEmpty()) {
        	int cur = queue.pollFirst();
        	
        	ans.add(cur);
        	for (int next : graph[cur]) {
        		inDegree[next]--;
        		if (inDegree[next] == 0) queue.add(next);
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int a : ans) sb.append(a + " ");
        System.out.println(sb);
        
    }
}