/**
 * @author choi
 * @date Jan 10, 2021
 * @see https://www.acmicpc.net/problem/1405
 * @mem 12,620kb
 * @time 140ms
 * @caution
 * [고려사항]
 * 동,서,남,북 순으로 확률이 입력된다.
 * 소수점 9째짜리까지 오차가 허용되므로 printf("%.9f")를 통해 출력해야하고, float는 소수 6째 자리까지만 인식하므로
 * double로 선언해야한다. 최대 14번까지 움직이므로 배열을 30? 31의 크기의 2차원 배열로 선언.
 * 문제가 많이 헷갈렸는데, 로봇의 이동경로가 단순하다. (=이미 지나왔던 지점을 다시는 지나치지 않는다.) 의 의미이다.
 * 14 25 25 25 25라하면, 14번 동안 일정 확률로 방향이 ENWSWENS...로 주어졌을 때 (단순한 경로의 경우 / 전체 경우)
 * 4 * 3 ^ 13의 경우의 수라고 생각되어진다.
 * 한번에 이해하기 어려웠던 문제.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS> '미친 로봇'
public class BOJ1405 {
    static int N;
    static double [] per = new double[4];
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    static boolean [][] visited = new boolean[31][31];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0;i<4;i++) {
            per[i] = (double)Integer.parseInt(st.nextToken()) / 100;
        }

        System.out.printf("%.9f",dfs(15,15,0));
    }

    public static double dfs(int x, int y, int depth) {
        if(depth == N) return 1;
        double result = 0;
        visited[x][y] = true;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!visited[nx][ny])
                result += dfs(nx,ny,depth+1) * per[i];
        }
        visited[x][y] = false;
        return result;
    }
}