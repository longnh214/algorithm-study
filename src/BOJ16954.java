/**
 * @author choi
 * @date Jan 3, 2021
 * @see https://www.acmicpc.net/problem/16954
 * @mem 76,248kb
 * @time 196ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS> '움직이는 미로 탈출'
public class BOJ16954 {
    static char [][] maze;
    //제자리와 8각을 나타낸 방향 배열
    static int [] dx = {0,1,1,0,-1,-1,-1,0,1};
    static int [] dy = {0,0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maze = new char[8][8];

        for(int i=0;i<8;i++) {
            String str = br.readLine();
            for(int j=0;j<8;j++) {
                maze[i][j] = str.charAt(j);
            }
        }

        //bfs 탐색하여 맨윗줄(가로)와 맨 오른쪽줄(세로)에 도달한다면 1을 출력, 안된다면 0
        System.out.println(bfs() ? 1 : 0);
    }

    //bfs 탐색 함수
    public static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        //가장 왼쪽 아래와 turn을 넣는다.
        q.offer(new Point(7,0,0));

        int turn = 0;

        while(!q.isEmpty()) {
            Point temp = q.poll();

            //이번 턴의 큐 값이 전부 처리되었다면 turn을 ++ 하고 벽을 내린다.
            if(turn != temp.depth) {
                turn++;
                down();
            }

            //큐의 좌표가 벽에 깔린 좌표랑 같다면.
            if(maze[temp.x][temp.y] == '#')
                continue;

            //이 if문 때문에 계속 메모리 초과가 났는데, 큐의 좌표가 맨 윗줄에 간다면 목표 지점까지 벽이 없기 때문에 무조건 통과하고,
            //큐의 좌표가 맨 오른쪽 줄에 도달한다면 목표 지점까지 벽이 생길 일은 없기 때문에(벽은 계속 아래로 밀리고 새로 벽이 생기진 않는다.)
            //큐의 좌표가 맨 윗 줄이나 맨 오른쪽 줄에 도달한다면 목표 지점에 도달할 수 있다.(return true.)
            if(temp.x == 0 || temp.y == 7)
                return true;

            //자기 자신까지 9방향 탐색.
            for(int i=0;i<9;i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                //좌표 안에 있고 다음 좌표가 벽이 아니라면
                if(isIn(nx,ny) && maze[nx][ny] != '#') {
                    q.offer(new Point(nx,ny,temp.depth+1));
                }
            }
        }

        return false;
    }

    //벽을 아래로 옮기는 함수
    public static void down() {
        for(int i=0;i<8;i++) {
            for(int j=6;j>=0;j--) {
                maze[j+1][i] = maze[j][i];
                maze[j][i] = '.';
            }
        }
    }

    //좌표가 유효한 좌표인지.
    public static boolean isIn(int x, int y) {
        return x>=0 && x<8 && y>=0 && y<8;
    }

    //Point 객체
    static class Point{
        int x;
        int y;
        int depth;
        Point(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}