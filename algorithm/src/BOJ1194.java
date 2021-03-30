/**
 * @author choi
 * @date Nov 2, 2020
 * @see https://www.acmicpc.net/problem/1194
 * @mem 14,736kb
 * @time 112ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS/비트마스킹> '달이 차오른다 가자'
public class BOJ1194 {
    static int N, M, startX, startY, answer;
    static boolean[][][] visited;
    static char[][] map;
    // 오른쪽, 아래, 왼쪽, 위 순서
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        answer = Integer.MAX_VALUE;
        visited = new boolean[N][M][(1 << 6)];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0') {
                    startX = i;
                    startY = j;
                }
            }
        }
        System.out.println(bfs(startX, startY));
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y][0] = true;
        q.offer(new Point(x, y, 0, 0));

        while (!q.isEmpty()) {
            Point temp = q.poll();

            if (map[temp.x][temp.y] == '1') {
                return temp.length;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                int nBit = temp.bit;

                // 범위 밖이면 통과
                if (!isIn(nx,ny)) {
                    continue;
                }
                // 벽을 만나면 통과
                if (map[nx][ny] == '#') {
                    continue;
                }
                // a 와 f 사이 키 일때 해당 위치의 값을 1로 만들어준다.
                if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
                    nBit |= (1 << map[nx][ny] - 'a');
                }
                // A 와 F 사이 키를 갖고 있는지 확인한 후 없다면 패스한다.
                if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
                    if ((nBit & (1 << (map[nx][ny] - 'A'))) == 0) {
                        continue;
                    }
                }
                // 해당 위치에 똑같은 키들을 갖고 방문했다면 패스
                if (visited[nx][ny][nBit]) {
                    continue;
                }
                // 해당 위치에 똑같은 키들을 갖고 방문한 적 없으면 방문 후, 재 방문 금지하기 위한 조건걸어둠.
                visited[nx][ny][nBit] = true;
                q.offer(new Point(nx, ny, nBit, temp.length + 1));
            }
        }
        return -1;
    }

    static class Point {
        int x;
        int y;
        int bit;
        int length;

        Point(int x, int y, int bit, int length) {
            this.x = x;
            this.y = y;
            this.bit = bit;
            this.length = length;
        }
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}