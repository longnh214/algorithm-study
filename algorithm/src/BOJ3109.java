/**
 * @author choi
 * @date Aug 27, 2020
 * @see https://www.acmicpc.net/problem/3109
 * @mem 48,216kb
 * @time 324ms
 * @caution
 * [고려사항]
 * 가지 못했을 경우를 체크하는 데에 .을 x로 바꿔주는 방법이 있음을 알 수 있었다.
 * flag를 static으로 선언하여 정답에 도달했을 경우에는 해당 dfs를 return 시켜주고 answer++를 하면 됐었다.
 * visited 2차원 배열을 선언했었는데, 방문하면 map을 .에서 x로 바꿔서 메모리를 절약할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <백트래킹> '빵집'
public class BOJ3109 {
    static int N,M,answer;
    static char [][] map;
    static int [] dx = {-1,0,1};
    static int [] dy = {1,1,1};
    static boolean isAnswer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0;i<N;i++) {
            map[i] = br.readLine().toCharArray();
        }


        for(int i=0;i<N;i++) {
            isAnswer = false;
            dfs(i,0);
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y) {
        if(y == M-1) {
            isAnswer = true;
            answer++;
            return;
        }

        for(int i=0;i<3;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isIn(nx,ny) && map[nx][ny] == '.') {
                map[x][y] = 'x';
                dfs(nx,ny);
                if(isAnswer)
                    return;
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}