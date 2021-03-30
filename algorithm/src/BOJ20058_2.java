/**
 * @author choi
 * @date Feb 2, 2021
 * @see https://www.acmicpc.net/problem/20058
 * @mem 32,856kb
 * @time 300ms
 * @caution
 * [고려사항]
 * temp 배열을 쓰지 않고 배열 복사를 이용했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '마법사 상어와 파이어스톰'
public class BOJ20058_2 {
    static int N,Q,size,max;
    static int [] command;
    static int [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = (int)Math.pow(2, N);
        map = new int[size][size];
        command = new int[Q];
        visited = new boolean[size][size];

        for(int i=0;i<size;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<size;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<Q;i++) {
            if(command[i] != 0) {
                fireball(command[i]);
                tornado();
            }else {
                tornado();
            }
        }

        System.out.println(sum());

        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(!visited[i][j] && map[i][j] > 0)
                    max = Math.max(max, bfs(i,j));
            }
        }

        System.out.println(max);
    }

    public static void fireball(int l) {
        int tempSize = (int) Math.pow(2, l);
        int[][] next = new int[size][size];

        //세로 덩어리
        for (int i = 0; i < size; i += tempSize) {

            //작은 덩어리
            for (int j = 0; j < size; j += tempSize) {
                for (int k = 0; k < (int) Math.pow(2, l); k++) {
                    for (int m = 0; m < (int) Math.pow(2, l); m++) {
                        next[i + m][j - k + (int) Math.pow(2, l) - 1] = map[i + k][j + m];
                    }
                }
            }
        }
        map = next;
    }

    public static void tornado() {
        Queue<Point> q = new LinkedList<>();
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                if(map[i][j] > 0) {
                    int count = 0;
                    for(int k=0;k<4;k++) {
                        if(isIn(i+dx[k],j+dy[k]) && map[i+dx[k]][j+dy[k]] > 0) {
                            count++;
                        }
                    }

                    if(count < 3)
                        q.offer(new Point(i,j));
                }
            }
        }

        while(!q.isEmpty()) {
            Point temp = q.poll();
            map[temp.x][temp.y]--;
        }
    }

    public static int sum() {
        int output = 0;
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                output += map[i][j];
            }
        }
        return output;
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<size && y>=0 && y<size;
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Point(x,y));
        int count = 1;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] > 0) {
                    count++;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx,ny));
                }
            }
        }

        return count;
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