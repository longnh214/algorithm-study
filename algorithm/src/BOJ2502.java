/**
 * @author nakhoon
 * @date 2022, 3월 25일
 * @see https://www.acmicpc.net/problem/2502
 * @mem 11,456kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 첫 날 준 떡이 A 이고, 두번째 날에 준 떡이 B개라면
 * A, B, A+B, A+2B, 2A+3B, 3A+5B, ...으로 A의 계수와 B의 계수가 피보나치 수열로 늘어나는 것을 볼 수 있다.
 * 처음에는 A와 B를 둘 다 1부터 올리면서 계산하려했지만 이후에 시간 초과가 발생해서
 * ax+by = k를 해결할 때 k - ax = by에서 (k-ax)%b 가 0일 때를 조건식으로 해서 두 수를 출력했다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <DP> '떡 먹는 호랑이'
public class BOJ2502 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] A = new int[32];
        int [] B = new int[32];
        A[0] = 1;
        B[1] = 1;
        for(int i=2;i<=31;i++){
            A[i] = A[i-2] + A[i-1];
            B[i] = B[i-2] + B[i-1];
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int first;
        int second;
        for(int i=1;;i++){
            int res = K - A[D-1] * i;

            if (res % B[D-1] == 0) {
                first = i;
                second = res / B[D-1];
                break;
            }
        }
        System.out.println(first);
        System.out.println(second);
    }
}