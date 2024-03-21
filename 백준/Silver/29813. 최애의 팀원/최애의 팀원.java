import java.io.*;
import java.util.*;

public class Main {
    static class Student {
        private String name;
        private int hakbun;
        public Student(String name, int hakbun) {
            this.name = name;
            this.hakbun = hakbun;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // deque
        Queue<Student> line = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int hakbun = Integer.parseInt(st.nextToken());
            line.add(new Student(name, hakbun));
        }

        while (N > 1) {
            Student cur = line.poll();
            int curHakbun = cur.hakbun;
            Queue<Student> tempLine = new ArrayDeque<>();
            int pass = (curHakbun - 1) % (N - 1);
            while (pass --> 0) {
                tempLine.offer(line.poll());
            }
            line.poll();
            for (Student st : tempLine) line.offer(tempLine.poll());
            N-=2;
        }

        System.out.println(line.poll().name);

    }
}
