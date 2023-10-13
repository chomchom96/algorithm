import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
 
public class Main {
	
	static class TrieNode {
		Map<Character, TrieNode> childs = new HashMap<>();
		boolean isTerminal; // 종단 노드인가?
	}
	
	static class Trie {
		TrieNode root = new TrieNode(); // 트라이 트리의 루트는 빈 노드며 유일함
		
		boolean insertNode(String number) { // 입력받은 전화번호를 트라이 트리에 넣기
			TrieNode thisNode = root;
			for (int i = 0; i < number.length(); i++) { // 전화번호 앞번호부터 트리에 넣기
				char cur = number.charAt(i);
				if (thisNode.childs.get(cur) == null) { // 트라이에 등록되지 않은 번호임!
					thisNode.childs.put(cur, new TrieNode());
				}
				thisNode = thisNode.childs.get(cur);
				if (thisNode.isTerminal) return false;
			}
			if (thisNode.childs.size() > 0) return false;
			
			thisNode.isTerminal = true;
			return true;
		}
		
	}
	
    public static void main(String[] args) throws IOException {	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
    	while (t --> 0) {
    		Trie trie = new Trie();
    		boolean flag = true;
    		
    		int n = Integer.parseInt(br.readLine());
    		while (n --> 0) {
    			String num = br.readLine();
    			if (!flag) continue;
    			if (!trie.insertNode(num)) flag = false;
    		}
    		System.out.println(flag? "YES" : "NO");
    		
    	}
    	
    }
}