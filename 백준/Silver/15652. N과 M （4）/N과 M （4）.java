import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static boolean[] isUsed = new boolean[N];
	static int[] result = new int[M];    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		isUsed = new boolean[N];
        result = new int[M];
        
		NM(0,0);
		
	}
	
	static void NM(int cnt, int start) {
		
		if(cnt == M) { 
			for(int m = 0; m<cnt;m++) {
				System.out.print(result[m]);
				if(m == cnt-1) {
					System.out.println();
				}else {
					System.out.print(" ");
				}
					
			}
			return;
		}
		for(int i = start; i <N; i ++) {
			if(isUsed[i] == false) { 
//				isUsed[i] = true; 
				result[cnt] = i+1;  
				NM(cnt+1, i); 
//				isUsed[i] = false; 
			}	
		}		
	}
}