/**
 * @author choi
 * @date 2020. 7. 29
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq
 * @mem 17,688 kb
 * @time 111ms
 * @caution
 * [고려사항] 4중 for문이 아니라 더 좋은 방법이 있을 것 같은데 다른 방법도 생각해봐야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//SW expert <D2> - '파리 퇴치'
public class Solution2001 {
    static int [][] map;
    static int N;
    static int M,Answer,sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            sum = 0;
            Answer = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<=N-M;i++) {
                for(int j=0;j<=N-M;j++) {
                    for(int k=0;k<M;k++) {
                        for(int m=0;m<M;m++) {
                            sum+=map[i+k][j+m];
                        }
                    }
                    Answer = Math.max(Answer, sum);
                    sum = 0;
                }
            }
            System.out.println("#" + t + " " + Answer);
        }
    }
}