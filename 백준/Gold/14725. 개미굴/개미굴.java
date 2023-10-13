import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
 
public class Main {
	
	static class TrieNode {
		Map<String, TrieNode> childs = new TreeMap<>();
	}
	
	static class Trie {
		TrieNode root = new TrieNode();
		
		void insertNode(String[] number) { 
			TrieNode thisNode = root;
			for (int i = 0; i < number.length; i++) { 
				String cur = number[i];
				if (thisNode.childs.get(cur) == null) { 
					thisNode.childs.put(cur, new TrieNode());
				}
				thisNode = thisNode.childs.get(cur);
			}
		}
		
		void printTree(TrieNode t, int depth) {
			if (!t.childs.isEmpty()) {	
				for (String c : t.childs.keySet()) {
					for (int i = 0; i < 2 * (depth); i++) {
						System.out.print("-");
					}
					System.out.println(c);
					if (t.childs.get(c) != null) {
						printTree(t.childs.get(c), depth + 1);
					}
				}
			}
			
		}
		
	}
	
    public static void main(String[] args) throws IOException {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Trie trie = new Trie();
		
		int n = Integer.parseInt(br.readLine());
		while (n --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int depth = Integer.parseInt(st.nextToken());
			String[] arr = new String[depth];
			for (int i = 0; i < depth; i++) arr[i] = st.nextToken();
			trie.insertNode(arr);
		}
		// 트라이 입력은 끝났고
		// 트라이 트리를 중위순회 해야함
		trie.printTree(trie.root, 0);	
    }
}