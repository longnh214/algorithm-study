/**
 * @author choi
 * @date Oct 9, 2020
 * @see https://www.acmicpc.net/problem/14503
 * @mem 13,424kb
 * @time 92ms
 * @caution
 * [고려사항]
 * 인덱스를 잘못 넣어줘서 시간이 오래걸렸던 문제이다... 체크를 잘해보자.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현/삼성기출> '로봇 청소기'
public class BOJ14503 {
    static int N,M;
    static int [][] arr;
    static boolean [][] visited;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(r,c,dir);

        System.out.println(count);
    }

    public static void bfs(int r, int c, int dir) {
        Queue<Point> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new Point(r,c,dir));

        while(!q.isEmpty()) {
            Point temp = q.poll();

            int searchCount = 0;
            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[(temp.dir+(i+1)*3)%4];
                int ny = temp.y + dy[(temp.dir+(i+1)*3)%4];

                if(isIn(nx,ny)) {
                    if(!visited[nx][ny] && arr[nx][ny] == 0) {
                        q.offer(new Point(nx,ny,(temp.dir+(i+1)*3)%4));
                        count++;
                        visited[nx][ny] = true;
                        break;
                    }
                }
                searchCount++;
            }
            if(searchCount == 4) {
                int nx = temp.x - dx[temp.dir];
                int ny = temp.y - dy[temp.dir];
                if(isIn(nx,ny) && arr[nx][ny] == 0) {
                    q.offer(new Point(nx,ny,temp.dir));
                }
                else {
                    break;
                }
            }
        }
    }

    //북 : 0 동 : 1 남 : 2 서 : 3

    public static boolean isIn(int x, int y) {
        return x>=1 && x<N-1 && y>=1 && y<M-1;
    }

    static class Point{
        int x;
        int y;
        int dir;
        Point(int x, int y, int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}