import java.util.*;
import java.io.*;
//백준 6118번 <다익스트라/최단 경로> - '숨바꼭질'
public class BOJ6118 {
    static int N;
    static int M;
    static List<Integer> [] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N+1];
        for(int i=1;i<=N;i++)
            map[i] = new ArrayList<>();

        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
        //출력해야 하는 변수들
        int number = 2;
        int maxDistance = Integer.MIN_VALUE;
        int count = 1;

        //BFS 시작
        Queue<Node> q = new LinkedList<>();
        boolean [] visited = new boolean[N+1];
        //첫 번째 방문 노드는 무조건 1이기 때문에 1 대입.
        q.add(new Node(1, 0));
        visited[1] = true;

        while(!q.isEmpty()){
            Node nowNode = q.poll();
            //최대 거리가 갱신 되었다면 변수의 값을 전부 바꿔준다.(개수 1, 최소값, count 갱신)
            if(maxDistance < nowNode.distance){
                maxDistance = nowNode.distance;
                number = nowNode.index;
                count = 1;
            }
            //최대거리와 같은 거리의 노드가 poll되었다면 count++
            else if(maxDistance == nowNode.distance){
                count++;
                //항상 최소값으로 number는 저장해줘야한다.
                if(number > nowNode.index)
                    number = nowNode.index;
            }

            for(int i : map[nowNode.index]){
                if(visited[i]) continue;

                q.add(new Node(i, nowNode.distance+1));
                visited[i] = true;
            }
        }
        System.out.println(number + " " + maxDistance + " " + count);
        br.close();
    }
    //Node 클래스
    static class Node{
        int index;
        int distance;
        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
}