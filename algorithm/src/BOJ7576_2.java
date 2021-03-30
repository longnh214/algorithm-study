/**
 * @author choi
 * @date 2020. 8. 5
 * @see https://www.acmicpc.net/problem/7576
 * @mem 128,696kb
 * @time 608ms
 * @caution
 * [고려사항] 날짜를 어떻게 처리해야할 지 고민하다가 클래스 안에 day 변수를 만들어서 접근할 때마다 day+1을 해준 클래스를 큐에 넣었다.
 * [입력사항] M,N이 반대여서 헷갈렸다.
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DFS/BFS> - '토마토'
public class BOJ7576_2 {
    static int N,M;
    static int [][] garage;
    static List<Dot> tomato;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        garage = new int[N][M];
        tomato = new ArrayList<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                garage[i][j] = Integer.parseInt(st.nextToken());
                if(garage[i][j] == 1) {
                    tomato.add(new Dot(i,j,0));
                }
            }
        }

        bfs();
    }
    public static void bfs() {
        Queue<Dot> q = new LinkedList<>();
        for(Dot dot : tomato) {
            q.offer(dot);
        }
        int day = 0;
        while(!q.isEmpty()) {
            Dot temp = q.poll();
            day = temp.day;
            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if(isIn(nx,ny) && garage[nx][ny] == 0) {
                    garage[nx][ny] = 1;
                    q.offer(new Dot(nx,ny,day+1));
                }
            }
        }
        //큐를 다 돌면 최종적인 day(익힌 총 날짜)가 저장된다.
        if(isFinish())
            System.out.println(day);
        else
            System.out.println(-1);
    }
    //좌표 클래스
    static class Dot{
        int x;
        int y;
        int day;
        Dot(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    //끝났는가.
    public static boolean isFinish() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(garage[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    //좌표가 유효한 좌표인가.
    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}