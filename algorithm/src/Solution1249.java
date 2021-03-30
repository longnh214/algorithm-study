/**
 * @author choi
 * @date Oct 29, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
 * @mem 22,328kb
 * @time 167ms
 * @caution
 * [고려사항]
 * 우선순위큐를 이용한 bfs와 dp를 이용하여 풀 수 있었던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D4> '보급로'
public class Solution1249 {
    static int N,answer,max;
    static int [][] map;
    static int [][] dp;
    static int [] dx = {1,0,-1,0};
    static int [] dy = {0,1,0,-1};
    static boolean [][] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            N = Integer.parseInt(br.readLine());

            max = 9*(2*N-3);
            map = new int[N][N];
            dp = new int[N][N];

            for(int i=0;i<N;i++) {
                String str = br.readLine();
                for(int j=0;j<N;j++) {
                    map[i][j] = str.charAt(j) - '0';
                    dp[i][j] = max;
                }
            }

            bfs();

            System.out.println("#" + t + " " + answer);
        }
    }

    public static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0,0,0));
        dp[0][0] = 0;

        while(!pq.isEmpty()) {
            Point temp = pq.poll();

            if(temp.x == N-1 && temp.y == N-1) {
                answer = temp.cost;
                break;
            }

            for(int i=0;i<4;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(isIn(nx,ny)) {
                    int nCost = temp.cost + map[nx][ny];
                    if(nCost < dp[nx][ny]) {
                        dp[nx][ny] = nCost;
                        pq.offer(new Point(nx,ny,nCost));
                    }
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int cost;

        Point(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.cost, o.cost);
        }
    }
}