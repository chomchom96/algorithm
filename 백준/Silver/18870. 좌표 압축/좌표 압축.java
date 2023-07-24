import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numList.add(Integer.parseInt(token.nextToken()));
        }

        Set<Integer> numSet = new TreeSet<>(numList);
        TreeMap<Integer, Integer> dict = new TreeMap<>();
        int index = 0;
        for (Integer num : numSet) {
            dict.put(num, index);
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numList.size(); i++) {
            sb.append(dict.get(numList.get(i))).append(' ');
        }

        System.out.println(sb);
    }
}
