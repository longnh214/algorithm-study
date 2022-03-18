/**
 * @author nakhoon
 * @date 2022, 3월 18일
 * @see https://www.acmicpc.net/problem/9625
 * @mem 11,496kb
 * @time 80ms
 * @caution
 * [고려사항]
 * DP 배열을 두고 점화식을 만들어서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <DP> 'BABBA'
public class BOJ9625 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] A = new int[46];
        int [] B = new int[46];

        A[0] = 1;
        for(int i=1;i<=45;i++){
                A[i] = B[i - 1];
                B[i] = A[i - 1] + B[i - 1];
        }
        int K = Integer.parseInt(br.readLine());

        System.out.println(A[K] + " " + B[K]);
    }
}