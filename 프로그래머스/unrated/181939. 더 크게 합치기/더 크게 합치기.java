class Solution {
    public int solution(int a, int b) {
        String a1 = Integer.toString(a);
        String b1 = Integer.toString(b);
        String c = a1 + b1;
        String d = b1 + a1;
        if (Integer.parseInt(c) > Integer.parseInt(d) ) {
        	return Integer.parseInt(c);
        } else {
        	return Integer.parseInt(d);
        }
    }
}