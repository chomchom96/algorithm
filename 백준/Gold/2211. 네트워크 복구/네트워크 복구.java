import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Node>> l = new ArrayList<>();
    static List<Node> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i<=N; i++)
            l.add(new ArrayList<>());

        while(M-->0){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            l.get(A).add(new Node(A, B, val));
            l.get(B).add(new Node(B, A, val));
        }

        network();

        System.out.println(answer.size());
        for (Node node : answer)
            System.out.println(node.from + " " + node.to);
    }

    static void network(){
        boolean[] visited = new boolean[N+1];
        int[] dist = new int[N+1];
        for(int i = 1; i<=N; i++)
            dist[i] = Integer.MAX_VALUE;

        Queue<Node> q = new PriorityQueue<>();
        q.offer(new Node(1, 1, 0));
        visited[1] = true;
        dist[1] = 0;

        while(!q.isEmpty()){
            Node vertex = q.poll();

            if(!visited[vertex.to]) {
                visited[vertex.to] = true;
                answer.add(vertex);
            }

            for(int i = 0; i<l.get(vertex.to).size(); i++){
                Node nextV = l.get(vertex.to).get(i);

                if(dist[nextV.to] > dist[vertex.to] + nextV.val){
                    dist[nextV.to] = dist[vertex.to] + nextV.val;
                    q.offer(new Node(nextV.from, nextV.to, dist[nextV.to]));
                }
            }
        }
    }
}
class Node implements Comparable<Node>{
    int from, to, val;

    Node(int from, int to, int val){
        this.from = from;
        this.to = to;
        this.val = val;
    }

    @Override
    public int compareTo(Node a){
        return this.val - a.val;
    }
}