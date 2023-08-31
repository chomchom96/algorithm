import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static int n;
	static int[] parent;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
        	parent[i] = i;
        }
        
        for (int i = 0; i < m; i++) {
        	int a = list.get(i)[0];
        	int b = list.get(i)[1];
        	if (find(a) == find(b)) {
        		System.out.println(i + 1);
        		System.exit(0);
        	}
        	else union(a,b);
        }
        
        System.out.println(0);
        
    }
    
    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	
    	if (a > b) parent[a] = b;
    	else parent[b] = a;
    }
    
    static int find(int child) {
    	while (parent[child] != child) {
    		child = parent[child];
    	}
    	return child;
    }
   
}