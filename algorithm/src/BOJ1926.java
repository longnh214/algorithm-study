/**
 * @author nakhoonchoi
 * @date 2024/08/19
 * @see https://www.acmicpc.net/problem/1926
 * @mem 44,664kb
 * @time 320ms
 * @caution
 * [고려사항]
 * 오른쪽과 아래, 두 방향만 보려고 했지만 4방향을 봐야하는 예외 케이스가 있다는 것을 알 수 없었다.
 * 하지만 조금만 더 생각해보니 4방향이 나올 수 있다는 것을 알 수 있었다.
 * 외에는 평범한 BFS 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <BFS> '그림'

public class BOJ1926 {

    static int [][] arr;
    static boolean [][] visited;
    static int N, M;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static int max = 0;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    count++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        int broaden = 1;

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isIn(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    broaden++;
                }
            }
        }

        max = Math.max(max, broaden);
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
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