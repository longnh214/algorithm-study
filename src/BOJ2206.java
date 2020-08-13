/**
 * @author choi
 * @date 2020. 8. 12
 * @see https://www.acmicpc.net/problem/2206
 * @mem 137,996kb
 * @time 516ms
 * @caution
 * [고려사항] 큐에 좌표 값을 넣어야 할 조건을 잘 생각하고, 큐에 가장 먼저 빠져나오는 마지막 좌표 값이
 *      최소값이므로 그 때 break를 걸어줬으면 됐다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <DFS/BFS> '벽 부수고 이동하기'
public class BOJ2206 {
    static int N, M, answer;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs();
        if (answer != Integer.MAX_VALUE)
            System.out.println(answer);
        else
            System.out.println(-1);
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(0, 0, 0, 1));
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                answer = cur.length;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isIn(nx, ny))
                    continue;

                if (visited[nx][ny] <= cur.wall)
                    continue;

                if (isIn(nx, ny)) {
                    if (map[nx][ny] == 1) {
                        if (cur.wall == 0) {
                            visited[nx][ny] = cur.wall + 1;
                            q.offer(new Point(nx, ny, cur.wall + 1, cur.length + 1));
                        }
                    } else {
                        visited[nx][ny] = cur.wall;
                        q.offer(new Point(nx, ny, cur.wall, cur.length + 1));
                    }
                }
            }
        }
    }


    public static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Point {
        int x;
        int y;
        int wall;
        int length;

        public Point(int x, int y, int wall, int length) {
            super();
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.length = length;
        }
    }
}