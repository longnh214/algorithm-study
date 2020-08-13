/**
 * @author choi
 * @date 2020. 8. 12
 * @see https://www.acmicpc.net/status?user_id=cnh0214&problem_id=1261&from_mine=1
 * @mem 35,224kb
 * @time 288ms
 * @caution
 * [고려사항] 문제를 처음 봤을 때에는 문제를 잘못 접근해서 답을 계속 틀렸지만, 문제를 다시 천천히 읽고 푸니 생각보다 어려운 문제는 아니였다.
 *      분류는 다익스트라라고 되어있지만 bfs로도 풀 수 있는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <다익스트라> - '알고스팟'
public class BOJ1261 {
    static int N,M,Min;
    static int [][] visited;
    static int [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Min = Integer.MAX_VALUE;
        map = new int[M][N];
        visited = new int[M][N];
        for(int [] arr : visited) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for(int i=0;i<M;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs(new Dot(0,0,0));

        System.out.println(visited[M-1][N-1]);
    }

    public static void bfs(Dot dot) {
        Queue<Dot> q = new LinkedList<>();
        visited[dot.x][dot.y] = 0;
        q.offer(dot);

        while(!q.isEmpty()) {
            Dot temp = q.poll();

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny) && map[nx][ny] == 1) {
                    if(temp.wall + 1 < visited[nx][ny]) {
                        visited[nx][ny] = temp.wall + 1;
                        q.offer(new Dot(nx, ny, visited[nx][ny]));
                    }
                }
                if(isIn(nx,ny) && map[nx][ny] == 0) {
                    if(temp.wall < visited[nx][ny]) {
                        visited[nx][ny] = temp.wall;
                        q.offer(new Dot(nx, ny, visited[nx][ny]));
                    }
                }
            }
        }
    }

    static class Dot{
        int x;
        int y;
        int wall;
        public Dot(int x, int y, int wall) {
            super();
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<M && y>=0 && y<N;
    }
}