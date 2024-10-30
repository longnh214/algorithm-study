/**
 * @author nakhoonchoi
 * @date 2024/10/30
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/67259
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2020 카카오 인턴십> '경주로 건석'

public class Programmers67259 {
    static int min;
    static int N,M;
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
//        int [][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
//        int [][] board = {{0,0,0},{0,0,0},{0,0,0}};
        int [][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1}, {1,0,0,0}};

        System.out.println(solution(board));
    }

    public static int solution(int [][] board) {
        min = Integer.MAX_VALUE;
        N = board.length;
        M = board[0].length;
        return bfs(board);
    }

    public static int bfs(int [][] board){
        PriorityQueue<Status> pq = new PriorityQueue<>();
        if(isIn(0, 1) && board[0][1] == 0){
            pq.offer(new Status(0, 1, 3, 100));
        }
        if(isIn(1, 0) && board[1][0] == 0){
            pq.offer(new Status(1, 0, 1, 100));
        }

        while(!pq.isEmpty()){
            Status cur = pq.poll();

            if(cur.x == N - 1 && cur.y == M - 1){
                return cur.cost;
            }

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(isIn(nx, ny) && board[nx][ny] == 0){
//                    System.out.println(nx + ", " + ny + ", " + i + ", " + (cur.cost + ((cur.dir != i) ? 500 : 100)));
//                    System.out.println();
//                    visited[nx][ny] = true;
                    pq.offer(new Status(nx, ny, i, cur.cost + ((cur.dir != i) ? 600 : 100)));
                }
            }
        }

        return -1;
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<M;
    }

    static class Status implements Comparable<Status>{
        int x;
        int y;
        int dir;
        int cost;
        Status(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Status o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}