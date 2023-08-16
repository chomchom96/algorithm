import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int cnt = 0;
        int sum = 0;

        for(int i = 0; i< input.length(); i++) {
            if(input.charAt(i) =='(') {
                if(input.charAt(i+1) == ')') {
                    sum += cnt; i++;
                }else {
                    cnt++;
                }
            }else if(input.charAt(i) == ')'){
                sum +=1;
                cnt--;
            }
        }
        System.out.println(sum);
	}
}