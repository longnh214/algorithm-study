/**
 * @author nakhoonchoi
 * @date 2024/11/03
 * @see https://softeer.ai/practice/7594
 * @caution
 * [고려사항]
 * 재귀를 이용해서 문제를 해결하였다.
 * n의 크기가 작았고, 나무의 높이가 최대 10이기 때문에
 * int의 범위를 벗어나지 않을 것이라고 생각했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//소프티어 <연습문제> '나무 조경'

public class Softeer7594 {
    static int N;
    static int [][] map;
    static boolean [][] visited;
    static int maxPair;
    static int answer;
    static int [] dx = {1, 0};
    static int [] dy = {0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        maxPair = N != 2 ? 4 : 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, 0, 0);

        System.out.println(answer);
    }

    public static void func(int count, int sum, int x, int y){
        if(count == maxPair || (x == N-1 && y == N-1)){
            answer = Math.max(answer, sum);
            return;
        }

        int nextX = y == N-1 ? x+1 : x;
        int nextY = nextX != x ? 0 : y+1;

        if(!visited[x][y]) {
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isIn(nx, ny) && !visited[nx][ny]) {
                    visited[x][y] = true;
                    visited[nx][ny] = true;
                    func(count + 1, sum + map[x][y] + map[nx][ny], nextX, nextY);
                    visited[x][y] = false;
                    visited[nx][ny] = false;
                }
            }
        }

        func(count, sum, nextX, nextY);
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}