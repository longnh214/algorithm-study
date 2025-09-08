/**
 * @author nakhoonchoi
 * @date 2025/09/08
 * @see https://boj.ma/4485
 * @mem 17,308kb
 * @time 156ms
 * @caution
 * [고려사항]
 * 다익스트라로 풀 수도 있었겠지만,,, 익숙한 우선순위 큐를 이용한 BFS로 문제를 해결했다.
 * N이 최대 125이고, 각 구역 별 비용이 0~9이기 때문에 int 형으로 충분히 커버될 것이라고 생각했다.
 * 보통 visited 배열로 해당 구역을 방문했었는지 체크하지만,
 * 이번에는 최소 비용을 저장하는 minCost 배열을 이용해서 최소 비용을 갱신할 Point를 우선순위 큐에 담았다.
 *
 * BFS를 순회한 뒤에는 minCost[N-1][N-1]에 마지막 좌표에 대한 최소 비용이 저장될 것이기 때문에
 * 각 TC 별로 문제 번호와 minCost[N-1][N-1] 값을 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <BFS> '녹색 옷 입은 애가 젤다지?'

public class BOJ4485 {
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static int N;
    static int [][] arr;
    static int [][] minCost;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int problemNum = 1;

        while((N = Integer.parseInt(br.readLine())) != 0){
            arr = new int[N][N];
            minCost = new int[N][N];

            for(int i=0;i<N;i++){
                Arrays.fill(minCost[i], Integer.MAX_VALUE);

                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(problemNum++).append(": ").append(bfs()).append('\n');
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    public static int bfs(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        Point firstPoint = new Point(0, 0, arr[0][0]);
        minCost[0][0] = arr[0][0];
        pq.offer(firstPoint);

        while(!pq.isEmpty()){
            Point cur = pq.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isIn(nx, ny) && cur.cost + arr[nx][ny] < minCost[nx][ny]){
                    pq.offer(new Point(nx, ny, cur.cost + arr[nx][ny]));
                    minCost[nx][ny] = cur.cost + arr[nx][ny];
                }
            }
        }

        return minCost[N-1][N-1];
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int cost;

        Point(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}