import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Node{
    	int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
        
        public void insert(int n) {
        	if (n < this.value) {
        		if (left == null) {
        			this.left = new Node(n);
        		}
        		else this.left.insert(n);
        	}
        	else {
        		if (right == null) {
        			this.right = new Node(n);
        		}
        		else this.right.insert(n);
        	}
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = Integer.parseInt(br.readLine());
        Node tree = new Node(root);
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals(""))
                break;
            tree.insert(Integer.parseInt(input));
        }
        preOrder(tree);
    }
    
    static void preOrder(Node node) {
    	if (node.left != null) preOrder(node.left); 	
    	if (node.right != null) preOrder(node.right);
    	System.out.println(node.value);
    }
}