/**
 * @author choi
 * @date Aug 3, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN
 * @mem 25,360kb
 * @time 160ms
 * @caution
 * [고려사항] 과자는 꼭 두개를 뽑아야하는 조합이다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//SW expert <D3> - '한빈이와 Spot Mart'
public class Solution9229 {
    static int T,N,M,answer;
    static int [] snack;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            answer = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snack = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                snack[i] = Integer.parseInt(st.nextToken());
            }

            comb(0,0,0);

            System.out.println("#" + t + " " + (answer == Integer.MIN_VALUE ? -1 : answer));
        }
    }

    public static void comb(int cnt, int start, int sum) {
        if(cnt == 2) {
            if(sum <= M && sum > answer) {
                answer = sum;
            }
            return;
        }

        for(int i=start;i<N;i++)
            comb(cnt+1,i+1,sum+snack[i]);
    }
}