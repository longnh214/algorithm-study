/**
 * @author choi
 * @date Sep 4, 2020
 * @see https://www.acmicpc.net/problem/16236
 * @mem 13,572kb
 * @time 96ms
 * @caution
 * [고려사항]
 * 거리가 같을 때 상 좌 우 하의 우선순위를 갖게 하는 우선순위 큐를 만들면서 어려움을 겪었다.
 * 맨처음 우선순위는 거리이다. 거리가 가장 가까울 수록 좋고, 그 다음으로는 가장 위 일수록
 * 우선순위가 높으며, 마지막으로는 가장 왼쪽이여야 우선순위가 높다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <BFS/우선순위 큐> '아기 상어'
public class BOJ16236 {
    static int N,sharkX,sharkY,eatCnt;
    static int sharkSize = 2;
    static int [] dx = { -1, 0, 0, 1 };
    static int [] dy = { 0, -1, 1, 0 };
    static int answer;
    static int [][] map;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    if (map[i][j] == 9) {
                        sharkX = i;
                        sharkY = j;
                        map[i][j] = 0; // 처음 상어의 위치는 0으로 초기화
                    }
                }
            }
        }

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        // 상어의 처음 위치 큐에 삽입
        pq.offer(new Point(sharkX, sharkY, 0));
        visited = new boolean[N][N];
        visited[sharkX][sharkY] = true;

        while (!pq.isEmpty()) {
            Point temp = pq.poll(); // 상어의 현재 위치

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (!isIn(nx, ny))
                    continue;
                if (visited[nx][ny])
                    continue;
                visited[nx][ny] = true;

                if (map[nx][ny] <= sharkSize)
                    pq.offer(new Point(nx, ny, temp.time + 1));
            }

            //우선 순위 큐에 넣고 pq 맨 위의 값을 꺼내서 확인한다.
            if (pq.peek() != null) {
                Point peek = pq.peek();
                if (map[peek.x][peek.y] < sharkSize && map[peek.x][peek.y] > 0) {
                    // 큐에 담긴 pos에 있는 물고기가 상어보다 작으면 물고기를 먹는다
                    eatCnt++;
                    if (eatCnt == sharkSize) {
                        sharkSize++;
                        eatCnt = 0;
                    }
                    map[peek.x][peek.y] = 0;

                    // 큐를 비우고 상어를 peek 위치로 이동
                    pq.clear();
                    pq.offer(new Point(peek.x, peek.y, 0));
                    answer += peek.time;
                    visited = new boolean[N][N];
                    visited[peek.x][peek.y] = true;
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        //거리가 같다면 x,y좌표를 확인하여 가장 위쪽이거나, 왼쪽인 좌표를 우선으로 넣어준다.
        @Override
        public int compareTo(Point o) {
            if (this.time == o.time) {
                if (this.x == o.x)
                    return Integer.compare(this.y, o.y);
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.time, o.time);
        }
    }
}