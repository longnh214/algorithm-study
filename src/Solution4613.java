/**
 * @author choi
 * @date Sep 23, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQl9TIK8qoDFAXj
 * @mem 18,644kb
 * @time 106ms
 * @caution
 * [고려사항]
 * 반복문을 돌 때 인덱스 k의 범위를 잘 지정해주어야 문제를 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D4> '러시아 국기 같은 깃발'
public class Solution4613 {
    static int N,M,answer;
    static int [] W,B,R;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            W = new int[N];
            B = new int[N];
            R = new int[N];
            for(int i=0;i<N;i++) {
                String str = br.readLine();
                for(int j=0;j<M;j++) {
                    char c = str.charAt(j);
                    if(c == 'W') W[i]++;
                    else if(c == 'B') B[i]++;
                    else R[i]++;
                }
            }
            int sum = 0;
            //W가 나올 수 있는 기준 1 ~ N-2
            for(int i=1;i<N-1;i++) {
                //W 기준에서 B가 나올 수 있는 기준 2 ~ N-1
                for(int j=i;j<N-1;j++) {
                    int w = 0;
                    int b = 0;
                    int r = 0;

                    for(int k=0;k<i;k++) {
                        w += W[k];
                    }
                    for(int k=i;k<=j;k++) {
                        b += B[k];
                    }
                    for(int k=j+1;k<N;k++) {
                        r += R[k];
                    }
                    sum = Math.max(w+b+r, sum);
                }
            }
            answer = N*M - sum;
            System.out.println("#" + t + " " + answer);
        }
    }
}