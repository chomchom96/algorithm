import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            int n = Integer.parseInt(line);
            Node root = new Node();

            for (int i = 0; i < n; i++) {
                String input = reader.readLine();
                inputList.add(input);
                insert(root, input, 0);
            }

            int inputListSize = inputList.size();
            double result = 0;

            for (int i = 0; i < inputListSize; i++) {
                result += count(root, inputList.get(i), 0);
            }

            result /= n;

            System.out.printf("%.2f%n", result);
            root.deleteNode();
            inputList.clear();
            result = 0;
        }
    }

    static class Node {
        Node[] children = new Node[26];
        int childrenNum;
        int finish;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            childrenNum = 0;
            finish = 0;
        }

        void deleteNode() {
            for (int i = 0; i < 26; i++) {
                if (children[i] != null) {
                    children[i].deleteNode();
                }
            }
        }
    }

    static void insert(Node tree, String input, int index) {
        if (index == input.length()) {
            tree.finish = 1;
            return;
        }

        if (tree.children[input.charAt(index) - 'a'] == null) {
            Node newNode = new Node();
            preNode(newNode);
            tree.children[input.charAt(index) - 'a'] = newNode;
            tree.childrenNum++;
        }

        insert(tree.children[input.charAt(index) - 'a'], input, index + 1);
    }

    static int count(Node tree, String input, int index) {
        int ret = 0;

        if (index == input.length()) {
            return 0;
        }

        if (tree.childrenNum == 1) {
            if (index == 0) {
                ret = count(tree.children[input.charAt(index) - 'a'], input, index + 1) + 1;
            } else if (tree.finish == 0) {
                ret = count(tree.children[input.charAt(index) - 'a'], input, index + 1);
            } else if (tree.finish == 1) {
                ret = count(tree.children[input.charAt(index) - 'a'], input, index + 1) + 1;
            }
        } else {
            ret = count(tree.children[input.charAt(index) - 'a'], input, index + 1) + 1;
        }

        return ret;
    }

    static void preNode(Node newNode) {
        for (int i = 0; i < 26; i++) {
            newNode.children[i] = null;
        }
        newNode.childrenNum = 0;
        newNode.finish = 0;
    }
}
