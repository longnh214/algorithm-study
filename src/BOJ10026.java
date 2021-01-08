/**
 * @author choi
 * @date Jan 8, 2021
 * @see https://www.acmicpc.net/problem/10026
 * @mem 12,808kb
 * @time 96ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '적록색약'
public class BOJ10026 {
    static char [][] map;
    static char [][] map2;
    static int N;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        map2 = new char[N][N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R') map2[i][j] = 'G';
                else map2[i][j] = map[i][j];
            }
        }

        int normal = 0;
        int abnormal = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] != 'x') {
                    normal++;
                    bfs(map,map[i][j],i,j);
                }

                if(map2[i][j] != 'x') {
                    abnormal++;
                    bfs(map2,map2[i][j],i,j);
                }
            }
        }

        System.out.println(normal + " " + abnormal);
    }

    public static void bfs(char [][] arr, char c, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        arr[x][y] = 'x';

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny) && arr[nx][ny] == c) {
                    arr[nx][ny] = 'x';
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