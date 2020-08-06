/**
 * @author choi
 * @date Aug 6, 2020
 * @see https://www.acmicpc.net/problem/2961
 * @mem 12,992kb
 * @time 80ms
 * @caution
 * [고려사항] 부분집합 중에서 아무 것도 선택하지 않는 경우는 배제하지 않아 계속 틀렸다. 입력 숫자가 10억이 넘어가기 때문에 int가 아닌 long을
 * 		사용하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <재귀호출> - '도영이가 만든 맛있는 음식'
public class BOJ2961 {
    static long [] S, B;
    static long answer;
    static int N;
    static int [] temp;
    static boolean [] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new long[N];
        B = new long[N];
        answer = Long.MAX_VALUE;
        visited = new boolean[N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
        }

        for(int i=1;i<=N;i++) {
            temp = new int[i];
            comb(0,0,i);
        }

        System.out.println(answer);
    }

    public static void comb(int cnt,int start, int r) {
        if(cnt == r) {
            long sOutput = 1;
            long bOutput = 0;
            for(int i=0;i<temp.length;i++) {
                sOutput *= S[temp[i]];
                bOutput += B[temp[i]];
            }
            answer = Math.min(answer, Math.abs(sOutput - bOutput));
            return;
        }

        for(int i=start;i<N;i++) {
            temp[cnt] = i;
            comb(cnt+1,i+1,r);
        }
    }
}