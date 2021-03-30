/**
 * @author nakhoon
 * @date Mar 30, 2021
 * @see https://www.acmicpc.net/problem/17244
 * @mem 17,172kb
 * @time 128ms
 * @caution
 * [고려사항]
 * 비트마스킹을 잘 이해해야하는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <비트마스킹> '아맞다우산'
public class BOJ17244 {
    static char [][] map;
    static int N,M,exitX,exitY,count,startX,startY;
    static Point [] something = new Point[5];
    static int [][][] dp;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0;i<N;i++) {
            String str = br.readLine();

            for(int j=0;j<M;j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'X') {
                    something[count++] = new Point(i,j);
                }else if(map[i][j] == 'E') {
                    exitX = i;
                    exitY = j;
                }else if(map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        dp = new int[N][M][1 << count];

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        bfs(startX,startY);
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(x,y,0,0));

        dp[x][y][0] = 0;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            //exit에 도착했고 모든 물건 위치에 방문한 상태라면
            if(temp.x == exitX && temp.y == exitY && temp.bit == ((1 << count) - 1)) {
                System.out.println(temp.walk);
                break;
            }

            //dp 배열 값이 현재 걸음수보다 적다면 방문할 필요가 없다.
            if(dp[temp.x][temp.y][temp.bit] < temp.walk) continue;

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(isIn(nx,ny) && map[nx][ny] != '#') {
                    int nbit = temp.bit;

                    //물건인 경우
                    if(map[nx][ny] == 'X') {
                        int index = getIndex(nx,ny);
                        nbit |= (1 << index);
                    }

                    //현재 걸음 수+1이 dp 배열보다 작다면
                    if(dp[nx][ny][nbit] > temp.walk + 1) {
                        q.offer(new Point(nx,ny,nbit,temp.walk+1));
                        dp[nx][ny][nbit] = temp.walk + 1;
                    }
                }
            }
        }
    }

    public static int getIndex(int x, int y) {
        for(int i=0;i<something.length;i++) {
            if(something[i].x == x && something[i].y == y) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }

    static class Point{
        int x;
        int y;
        int bit;
        int walk;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        Point(int x, int y, int bit, int walk){
            this.x = x;
            this.y = y;
            this.bit = bit;
            this.walk = walk;
        }
    }
}