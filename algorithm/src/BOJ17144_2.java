/**
 * @author nakhoonchoi
 * @date 2024/09/21
 * @see https://www.acmicpc.net/problem/17144
 * @mem 139,656kb
 * @time 540ms
 * @caution
 * [고려사항]
 * 미세먼지의 확산은 bfs로,
 * 미세먼지의 이동은 배열 돌리기로 구현하였다.
 *
 * 미세먼지의 확산은 공기청정기와 관련이 없었다는 것을 늦게 알았다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '미세먼지 안녕!'

public class BOJ17144_2 {
    static int [] dx = {1, 0, -1, 0};
    static int [] dy = {0, 1, 0, -1};
    static int [] machineX;
    static int [][] map;
    static int R, C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        machineX = new int[2]; //열은 0으로 고정.

        map = new int[R][C];

        boolean flag = false;
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(!flag && map[i][j] == -1){
                    machineX[0] = i;
                    machineX[1] = i+1;
                    flag = true;
                }
            }
        }

        while(T-->0){
            bfs();
            rotateDust();
        }

        int sum = Arrays.stream(map).flatMapToInt(Arrays::stream).sum();

        System.out.println(sum + 2);
    }

    public static void bfs(){
        Queue<Dust> q = new LinkedList<>();

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] != -1 && map[i][j] > 0){
                    q.offer(new Dust(i, j, map[i][j]));
                }
            }
        }

        while(!q.isEmpty()){
            Dust cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int transferSize = cur.size / 5;

                if(isIn(nx,ny) && map[nx][ny] != -1){
                    map[cur.x][cur.y] -= transferSize;
                    map[nx][ny] += transferSize;
                }
            }
        }
    }

    public static void rotateDust(){
        int up = machineX[0];
        int down = machineX[1];

        //위 순환
        for(int i=up-1;i>=1;i--){
            map[i][0] = map[i-1][0];
        }
        for(int i=0;i<C-1;i++){
            map[0][i] = map[0][i+1];
        }
        for(int i=0;i<up;i++){
            map[i][C-1] = map[i+1][C-1];
        }
        for(int i=C-1;i>1;i--){
            map[up][i] = map[up][i-1];
        }
        map[up][1] = 0;

        //아래 순환
        for(int i=down+1;i<R-1;i++){
            map[i][0] = map[i+1][0];
        }
        for(int i=0;i<C-1;i++){
            map[R-1][i] = map[R-1][i+1];
        }
        for(int i=R-1;i>=down+1;i--){
            map[i][C-1] = map[i-1][C-1];
        }
        for(int i=C-1;i>1;i--){
            map[down][i] = map[down][i-1];
        }
        map[down][1] = 0;
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<R && y>=0 && y<C;
    }

    static class Dust{
        int x;
        int y;
        int size;

        public Dust(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
}