/**
 * @author choi
 * @date Sep 24, 2020
 * @see https://www.acmicpc.net/problem/1018
 * @mem 13,344kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 체스가 
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * 로만 이루어질 줄 알았는데
 *
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 *
 * 로도 체스를 이룰 수 있다는 것을 깨달았다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> '체스판 다시 칠하기'
public class BOJ1018 {
    static char [][] chess = new char[2][8];
    static char [][] map;
    static int N,M;
    public static void main(String[] args) throws IOException {
        chess[0] = "WBWBWBWB".toCharArray();
        chess[1] = "BWBWBWBW".toCharArray();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0;i<=N-8;i++) {
            for(int j=0;j<=M-8;j++) {
                int count1 = 0;
                int count2 = 0;
                for(int k=0;k<8;k++) {
                    for(int m=0;m<8;m++) {
                        if(chess[k%2][m] != map[i+k][j+m])
                            count1++;
                        if(chess[(k+1)%2][m] != map[i+k][j+m])
                            count2++;
                    }
                }
                answer = Math.min(count1, answer);
                answer = Math.min(count2, answer);
            }
        }

        System.out.println(answer);
    }
}