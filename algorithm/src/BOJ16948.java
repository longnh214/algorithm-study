/**
 * @author nakhoon
 * @date 2022, 3월 24일
 * @see https://www.acmicpc.net/problem/16948
 * @mem 12,560kb
 * @time 96ms
 * @caution
 * [고려사항]
 * BFS를 통해서 문제를 해결할 수 있었다. 좌표를 이용한 단순 BFS 문제이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 <BFS> '데스 나이트'
public class BOJ16948 {
    static int N;
    static int [] dx = {-2,-2,0,0,2,2};
    static int [] dy = {-1,1,-2,2,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean [][] visited = new boolean[N][N];
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;
        int answer = -1;

        while(!q.isEmpty()){
            Point cur = q.poll();

            if(cur.x == endX && cur.y == endY){
                answer = cur.route;
                break;
            }

            for(int i=0;i<6;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(isIn(nx,ny) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, cur.route+1));
                }
            }
        }
        System.out.println(answer);
    }

    static class Point{
        int x;
        int y;
        int route;
        Point(int x, int y, int route){
            this.x = x;
            this.y = y;
            this.route = route;
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}
