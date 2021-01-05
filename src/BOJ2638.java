/**
 * @author choi
 * @date Jan 5, 2021
 * @see https://www.acmicpc.net/problem/2638
 * @mem 40,064kb
 * @time 264ms
 * @caution
 * [고려사항]
 * 백준 2636 치즈 문제와 비슷한 문제.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '치즈'
public class BOJ2638 {
    static int N,M,time;
    static int [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> meltingQueue = new LinkedList<>();
        while(true) {
            spreadAir();

            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(map[i][j] == 1 && isMelt(i,j)) {
                        meltingQueue.offer(new Point(i,j));
                    }
                }
            }

            if(meltingQueue.isEmpty()) break;

            while(!meltingQueue.isEmpty()) {
                Point temp = meltingQueue.poll();
                map[temp.x][temp.y] = -1;
            }

            time++;
        }

        System.out.println(time);
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    public static void spreadAir() {
        Queue<Point> q = new LinkedList<>();
        boolean [][] visitedAir = new boolean[N][M];
        q.offer(new Point(0,0));
        map[0][0] = -1;
        visitedAir[0][0] = true;

        while(!q.isEmpty()) {
            Point temp = q.poll();
            int nx;
            int ny;
            for(int i=0;i<4;i++) {
                nx = temp.x + dx[i];
                ny = temp.y + dy[i];

                if(isIn(nx,ny) && !visitedAir[nx][ny] && map[nx][ny] <= 0) {
                    map[nx][ny] = -1;
                    visitedAir[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                }
            }
        }
    }

    public static boolean isMelt(int x, int y) {
        int count = 0;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isIn(nx,ny) && map[nx][ny] == -1)
                count++;
        }

        return count >= 2 ? true : false;
    }

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}