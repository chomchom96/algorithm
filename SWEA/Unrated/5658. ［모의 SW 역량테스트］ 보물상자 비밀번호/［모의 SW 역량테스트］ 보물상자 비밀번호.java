import java.io.*;
import java.util.*;

public class Solution {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    	
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int k = Integer.parseInt(st.nextToken());
        	String input = br.readLine();
        	input += input;
        	TreeSet<String> set = new TreeSet<>();
        	for (int i = 0; i < n; i++) {
        		String word = input.substring(i, i + n/4);
        		set.add(word);
        	}
        	String[] list = set.toArray(new String[set.size()]);
        	String word = list[list.length - k];
        	System.out.println("#" + t + " " + Integer.parseInt(word, 16));
        }
    }
}