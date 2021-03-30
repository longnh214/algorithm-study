/**
 * @author choi
 * @date 2020. 8. 7
 * @see https://www.acmicpc.net/problem/2468
 * @mem 53,400kb
 * @time 280ms
 * @caution
 * [고려사항] BFS를 visited 배열 안쓰고 풀다보니 습관이 되어서
 *          visited 처리를 해줘야 한다는 것을 까먹었는데
처리를 잘해주어야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS/BFS> '안전 영역'
public class BOJ2468_2 {
    static int N;
    static int [][] map;
    static int max;
    static int count;
    static int answer;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    static boolean [][] visited;
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        map = new int[N][N];
        max = Integer.MIN_VALUE;
        answer = Integer.MIN_VALUE;
        visited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for(int k=0;k<=max;k++) {
            count = 0;
            for(boolean [] arr : visited)
                Arrays.fill(arr, false);
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(!visited[i][j] && map[i][j] > k) {
                        bfs(i,j,k);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    public static void bfs(int x, int y, int limit) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x,y));

        while(!q.isEmpty()) {
            Point temp = q.poll();
            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(isIn(nx,ny) && map[nx][ny] > limit && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
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