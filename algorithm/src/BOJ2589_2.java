/**
 * @author choi
 * @date Aug 26, 2020
 * @see https://www.acmicpc.net/problem/2589
 * @mem 161,780kb
 * @time 380ms
 * @caution
 * [고려사항]
 * 배열을 잘 복사해야 하고, 각 육지마다 bfs를 돌려 가장 최장 거리로 갈 수 있는 곳을 구하고,
 * 그 이후에 그 bfs 돌린 값 중 가장 최대값을 출력해야한다. (2중 max 연산)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS/BFS> '보물섬'
public class BOJ2589_2 {
    static int N,M,answer;
    static char [][] map;
    static char [][] copy;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        copy = new char[N][M];
        for(int i=0;i<N;i++) {
            map[i] = br.readLine().toCharArray();
        }
        answer = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 'L') {
                    answer = Math.max(answer, bfs(i,j));
                }
            }
        }
        System.out.println(answer);
    }

    public static int bfs(int x, int y) {
        arrCopy();
        //각 지점에 도달하기 위한 시간을 저장
        int [][] time = new int[N][M];

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        copy[x][y] = 'X';
        time[x][y] = 0;

        while(!q.isEmpty()) {
            Point cur = q.poll();

            for(int i=0;i<4;i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isIn(nx,ny) && copy[nx][ny] == 'L') {
                    q.offer(new Point(nx,ny));
                    copy[nx][ny] = 'X';
                    time[nx][ny] = time[cur.x][cur.y] + 1;
                }
            }
        }

        int max = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                max = Math.max(max, time[i][j]);
            }
        }
        return max;
    }

    public static void arrCopy() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                copy[i][j] = map[i][j];
            }
        }
    }

    public static boolean isIn(int x,int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}