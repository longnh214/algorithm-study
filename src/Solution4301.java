/**
 * @author choi
 * @date Aug 6, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWLv-yZah48DFAVV
 * @mem 29,400 kb
 * @time 170 ms
 * @caution
 * [고려사항] 공식이 따로 있는 것이 아니라 코드 상에서 배열을 그려 길이가 2에 해당하는 부분을 전부 block 시키면 나머지 공간 
 * 			콩을 심을 수 있는 곳이라는 것을 생각해내야했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW expert <D4> - '콩 많이 심기'
public class Solution4301 {
    static int [][] farm;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            farm = new int[M][N];

            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(farm[i][j] == 1) continue;
                    else {
                        if(isIn(i+2,j))
                            farm[i+2][j] = 1;
                        if(isIn(i,j+2))
                            farm[i][j+2] = 1;
                    }
                }
            }
            int count = 0;
            for(int i=0;i<M;i++) {
                for(int j=0;j<N;j++) {
                    if(farm[i][j] == 0) count++;
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<M && y>=0 && y<N;
    }
}