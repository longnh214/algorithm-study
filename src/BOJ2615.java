/**
 * @author choi
 * @date Aug 26, 2020
 * @see https://www.acmicpc.net/problem/2615
 * @mem 13,108kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 	가장 왼쪽 인덱스를 기준으로 dfs 탐색을 4방향으로 해야하므로,
 * 	왼쪽 위부터 행 탐색을 하는 것이 아니라 열 탐색으로 해야 오목 중 가장 왼쪽 인덱스를 출력할 수 있다.
 * 	반례를 찾아봤지만 계속 틀려서 타인의 코드를 참조했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS> '오목'
public class BOJ2615{
    static int[] dx = { 1, 1, 0, -1 };
    static int[] dy = { 0, 1, 1, 1 };
    static int[][] game = new int[19][19];
    static int answer;
    static boolean[][][] visited = new boolean[19][19][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //왼쪽부터 탐색
        boolean flag = true;
        answer = 1;
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (game[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        if(!visited[i][j][k]) {
                            dfs(i, j, k);
                            if (answer == 5 && flag) {
                                System.out.println(game[i][j]);
                                System.out.println((i + 1) + " " + (j + 1));
                                flag = false;
                            }
                            answer = 1;
                        }
                    }
                }
            }
        }
        if(flag)
            System.out.println(0);
    }

    private static void dfs(int x, int y, int direction) {
        visited[x][y][direction] = true;

        int nx = x + dx[direction];
        int ny = y + dy[direction];

        if (isIn(nx, ny) && !visited[nx][ny][direction] && game[nx][ny] == game[x][y]) {
            answer++;
            dfs(nx, ny, direction);
        }
        return;
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}