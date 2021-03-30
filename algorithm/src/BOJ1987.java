/**
 * @author choi
 * @date Aug 27, 2020
 * @see https://www.acmicpc.net/problem/1987
 * @mem 280,448kb
 * @time 1,976ms
 * @caution
 * [고려사항]
 * 알파벳을 visited처리하기위해 배열이 아닌 Set을 쓴 방법.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <백트래킹> '알파벳'
public class BOJ1987 {
    static int R, C, max;
    static char [][] board;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    static Set<Character> visited = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        board = new char[R][];
        for(int i=0;i<R;i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(0,0,1);

        System.out.println(max);
    }

    public static void dfs(int x, int y, int count) {
        max = Math.max(count, max);

        visited.add(board[x][y]);

        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isIn(nx,ny) && !visited.contains(board[nx][ny])) {
                dfs(nx,ny,count+1);
            }
        }
        visited.remove(board[x][y]);
    }

    public static boolean isIn(int x,int y) {
        return x>=0 && x<R && y>=0 && y<C;
    }
}