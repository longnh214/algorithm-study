/**
 * @author choi
 * @date 2020. 8. 12
 * @see https://www.acmicpc.net/problem/9205
 * @mem 13,888kb
 * @time 104ms
 * @caution
 * [고려사항] 꼭 편의점의 위치가 상근이네 집 근처 순서대로 나오는 것이 아니라는 것을 생각하지 못했다.
 *       테스트케이스만 보고 단정지으면 안되고 어떤 반례가 있는 지 생각을 해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '맥주 마시면서 걸어가기'
public class BOJ9205 {
    static int N;
    static Point from,end;
    static Point [] cs;
    static boolean [] visited;
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(T-->0) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            cs = new Point[N+1];
            visited = new boolean[N+1];
            from = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                cs[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            cs[N] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            boolean success = false;

            q.offer(from);

            while(!q.isEmpty()) {
                Point to = q.poll();
                //도착 좌표를 접근할 수 있다면.
                if(to.x == cs[N].x && to.y == cs[N].y)
                    success = true;

                for(int i=0;i<cs.length;i++) {
                    if(!visited[i] && (Math.abs(cs[i].x - to.x) + Math.abs(cs[i].y - to.y) <= 1000)){
                        visited[i] = true;
                        q.offer(cs[i]);
                    }
                }
            }
            //페스티벌 좌표를 도달 했다면 happy, 실패라면 sad
            if(success)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}