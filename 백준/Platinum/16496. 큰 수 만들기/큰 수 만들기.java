import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static String[] arr;
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) arr[i] = (st.nextToken());
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        String ans = "";
        for (int i = 0; i < N; i++) ans += arr[i];
        if (ans.charAt(0) == '0') System.out.println(0);
        else System.out.println(ans);
    }
}