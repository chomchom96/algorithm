import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] chararray = a.toCharArray();
        char[] ans;
        for (char c : chararray) {
        	if (Character.isUpperCase(c)) {
        		System.out.print(Character.toLowerCase(c));
        	} else {
        		System.out.print(Character.toUpperCase(c));
        	}
        }
        sc.close();
    }
}