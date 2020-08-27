/**
 * @author choi
 * @date Aug 27, 2020
 * @see	https://www.acmicpc.net/problem/1987
 * @mem 13,900kb
 * @time 872ms
 * @caution
 * [고려사항]
 * visited를 static에서 초기화했더니 90%에서 틀렸다고 계산되었다.
 * (+ max와 count를 1로 초기화해야했다.)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <백트래킹> '알파벳'
public class BOJ1987_2 {
    static int R, C, max, count;
    static int [][] board;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,-0,-1,1};
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        visited = new boolean[26];
        for(int i=0;i<R;i++) {
            String str = br.readLine();
            for(int j=0;j<C;j++) {
                board[i][j] = str.charAt(j) - 'A';
            }
        }

        max = 1;
        count = 1;
        dfs(0,0);

        System.out.println(max);
    }

    public static void dfs(int x, int y) {
        visited[board[x][y]] = true;

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isIn(nx,ny) && !visited[board[nx][ny]]) {
                max = Math.max(++count, max);
                dfs(nx,ny);
            }
        }
        visited[board[x][y]] = false;
        --count;
    }

    public static boolean isIn(int x,int y) {
        return x>=0 && x<R && y>=0 && y<C;
    }
}