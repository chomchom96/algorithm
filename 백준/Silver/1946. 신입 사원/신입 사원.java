import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Applicant implements Comparable<Applicant> {
        int document;
        int interview;
        
        Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
        
        @Override
        public int compareTo(Applicant other) {
            return Integer.compare(this.document, other.document);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Applicant[] applicants = new Applicant[N];
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                applicants[i] = new Applicant(document, interview);
            }
            
            Arrays.sort(applicants);
            
            int count = 1;
            int minInterviewRank = applicants[0].interview;
            
            for (int i = 1; i < N; i++) {
                if (applicants[i].interview < minInterviewRank) {
                    count++;
                    minInterviewRank = applicants[i].interview;
                }
            }
            
            sb.append(count).append("\n");
        }
        
        System.out.print(sb);
    }
}