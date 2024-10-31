/**
 * @author nakhoonchoi
 * @date 2024/10/31
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/67259
 * @caution
 * [고려사항]
 * bfs로도 문제를 해결하였다.
 * 방향의 인덱스 이슈로 맞왜틀을 오래 했다...
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2020 카카오 인턴십> '경주로 건설'

public class Programmers67259_2 {
    static int min;
    static int N;
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
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j] == 0){
                    board[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        board[0][0] = 0;

        return bfs(board);
    }

    public static int bfs(int [][] board){
        PriorityQueue<Status> pq = new PriorityQueue<>();
        if(isIn(0, 1) && board[0][1] != 1){
            pq.offer(new Status(0, 1, 3, 100));
        }
        if(isIn(1, 0) && board[1][0] != 1){
            pq.offer(new Status(1, 0, 2, 100));
        }

        int result = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            Status cur = pq.poll();

            if(cur.x == N - 1 && cur.y == N - 1){
                result = Math.min(cur.cost, result);
                continue;
            }

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(!isIn(nx, ny) || board[nx][ny] == 1){
                    continue;
                }

                int cost = 100;
                if(cur.dir != i){
                    cost += 500;
                }
                cost += cur.cost;

                if(board[nx][ny] >= cost){
                    board[nx][ny] = cost;
                    pq.offer(new Status(nx, ny, i, cost));
                }else if(board[nx][ny] + 500 >= cost){
                    pq.offer(new Status(nx, ny, i, cost));
                }
            }
        }

        return result;
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
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