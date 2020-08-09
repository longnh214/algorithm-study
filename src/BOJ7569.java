/**
 * @author choi
 * @date Aug 9, 2020
 * @see https://www.acmicpc.net/problem/7569
 * @mem 119,976kb
 * @time 724ms
 * @caution
 * [고려사항] 익는 날짜를 계산할 때, 다른 배열을 하나 추가해서 값을 저장하는 방법과 class에 day 변수를 하나 지정해주는 방법이 있다는 것을
 *  		새로 생각해냈다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> - '토마토'
public class BOJ7569 {
    static int [] dz = {0,0,-1,1,0,0};
    static int [] dy = {0,0,0,0,-1,1};
    static int [] dx = {-1,1,0,0,0,0};
    static int H,M,N,answer;
    static int [][][] boxes, visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[H][M][N];
        visited = new int[H][M][N];
        answer = Integer.MIN_VALUE;

        for(int i=0;i<H;i++) {
            for(int j=0;j<M;j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<N;k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        bfs();

        if(!isFinish()) System.out.println(-1);
        else {
            for(int i=0;i<H;i++) {
                for(int j=0;j<M;j++) {
                    for(int k=0;k<N;k++) {
                        answer = Math.max(answer, visited[i][j][k]);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static void bfs() {
        Queue<Dot> q = new LinkedList<>();

        for(int i=0;i<H;i++) {
            for(int j=0;j<M;j++) {
                for(int k=0;k<N;k++) {
                    if(boxes[i][j][k] == 1) {
                        q.offer(new Dot(i,j,k));
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            Dot temp = q.poll();
            for(int i=0;i<6;i++){
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int nz = temp.z + dz[i];
                if(isIn(nx,ny,nz) && boxes[nx][ny][nz] == 0) {
                    boxes[nx][ny][nz] = 1;
                    visited[nx][ny][nz] = visited[temp.x][temp.y][temp.z] + 1;
                    q.offer(new Dot(nx,ny,nz));
                }
            }
        }
    }

    public static boolean isFinish(){
        for(int i=0;i<H;i++) {
            for(int j=0;j<M;j++) {
                for(int k=0;k<N;k++) {
                    if(boxes[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }
    public static boolean isIn(int x,int y,int z) {
        return x>=0 && x<H && y>=0 && y<M && z>=0 && z<N;
    }

    static class Dot{
        int x;
        int y;
        int z;
        public Dot(int x, int y, int z) {
            super();
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}