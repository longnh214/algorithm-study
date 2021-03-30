import java.util.*;
import java.io.*;
//백준 1753번 <다익스트라> - '최단경로'
public class BOJ1753 {
    static int [] distance;//최소 가중치 값을 저장할 배열
    static final int INF = Integer.MAX_VALUE;//INF 값 설정
    static List<Node>[] list;//각 노드로 시작하는 간선 정보 저장
    static int v,e,k;//정적 변수들

    //노드 클래스 + PriorityQueue에 들어갈 수 있도록 Comparable 인터페이스 상속 및 compareTo 지정
    static class Node implements Comparable<Node>{
        int end;
        int weight;

        Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        list = new ArrayList[v+1];
        distance = new int[v+1];

        //처음에 distance 배열을 전부 INF(int형 최대값)으로 채운다.
        Arrays.fill(distance, INF);

        //list 배열마다 ArrayList 객체 생성
        for(int i=1;i<=v;i++)
            list[i] = new ArrayList<>();

        //간선 개수만큼 입력 받아 list의 start 인덱스에 있는 각 리스트에 간선을 저장
        while(e-->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        //다익스트라 메소드 실행
        dijkstra(k);

        //dist 값이 최대값과 같다면 INF, 아니라면 그 값을 출력.
        for(int i=1;i<=v;i++){
            if(distance[i] == INF) System.out.print("INF\n");
            else System.out.print(distance[i] + "\n");
        }

    }

    //다익스트라 메소드(우선순위 큐 이용)
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean [] visited = new boolean[v+1];
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;

            if(visited[cur] == true) continue;
            visited[cur] = true;

            for(Node node : list[cur]){
                if(distance[node.end] > distance[cur] + node.weight){
                    distance[node.end] = distance[cur] + node.weight;
                    pq.add(new Node(node.end, distance[node.end]));
                }
            }
        }
    }
}