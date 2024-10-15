import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int L, S;
        long[] arr = new long[100];
        List<Pair> goodNums = new ArrayList<>();

        L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            goodNums.add(new Pair(0L, arr[i]));
        }
        Arrays.sort(arr, 0, L);
        S = Integer.parseInt(br.readLine());

        findGoodNums(goodNums, 1, arr[0] - 1, S);
        for (int i = 0; i < L - 1; i++) {
            findGoodNums(goodNums, arr[i] + 1, arr[i + 1] - 1, S);
        }

        Collections.sort(goodNums);

        long printedCount = 0;
        List<Long> printed = new ArrayList<>();
        for (int i = 0; i < Math.min(S, goodNums.size()); i++) {
            System.out.print(goodNums.get(i).second + " ");
            printed.add(goodNums.get(i).second);
            printedCount++;
        }
        long num = 0;
        while (printedCount < S) {
            num++;
            if (!printed.contains(num)) {
                System.out.print(num + " ");
                printed.add(num);
                printedCount++;
            }
        }
    }

    private static void findGoodNums(List<Pair> goodNums, long left, long right, int S) {
        long rangeCount = right - left;
        long inc = rangeCount - 1;
        long pushCount = 0;
        for (long i = 0; i <= (left + right) / 2; i++) {
            if (pushCount > S || right - i < left + i) break;
            goodNums.add(new Pair(rangeCount, left + i));
            pushCount++;
            if (right - i != left + i) {
                goodNums.add(new Pair(rangeCount, right - i));
                pushCount++;
            }
            rangeCount += inc;
            inc -= 2;
        }
    }

    static class Pair implements Comparable<Pair> {
        Long first;
        Long second;

        Pair(Long first, Long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            int cmp = this.first.compareTo(other.first);
            if (cmp == 0) {
                return this.second.compareTo(other.second);
            }
            return cmp;
        }
    }
}