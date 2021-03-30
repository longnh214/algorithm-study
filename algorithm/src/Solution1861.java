/**
 * @author choi
 * @date 2020. 7. 31
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE
 * @mem 30,760 kb
 * @time 410 ms
 * @caution
 * [고려사항] dfs를 이용해서 사방에 현재 내 배열값보다 1 더 큰 값이 없다면 return 1,
 *          있다면 1 + DFS(찾은 인덱스)를 리턴해준다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//SW expert <D4> - '정사각형 방'
import java.util.*;
public class Solution1861 {
    static int N;
    static int [][] map;
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,-1,0,1};
    static int max,answerNum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            N = Integer.parseInt(br.readLine());
            max = Integer.MIN_VALUE;
            answerNum = Integer.MAX_VALUE;//가장 작아야한다.
            map = new int[N][N];

            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    //각 배열 인덱스에 접근
                    if(dfs(i,j) > max) {
                        answerNum = map[i][j];
                        max = dfs(i,j);
                    }else if(max == dfs(i,j)) {
                        answerNum = answerNum > map[i][j] ? map[i][j] : answerNum;
                    }
                }
            }
            System.out.printf("#%d %d %d\n",t,answerNum,max);
        }
    }
    //나보다 1 큰 값이 있는 지 찾는 dfs
    public static int dfs(int i, int j) {
        for(int k=0;k<4;k++) {
            if(isIn(i+dx[k],j+dy[k]) && map[i][j] + 1 == map[i+dx[k]][j+dy[k]]) {
                return 1 + dfs(i+dx[k],j+dy[k]);
            }
        }
        return 1;
    }
    //범위 안에 있는가.
    public static boolean isIn(int Y, int X) {
        return Y>=0 && Y<N && X>=0 && X<N;
    }
}