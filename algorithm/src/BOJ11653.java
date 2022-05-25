/**
 * @author nakhoon
 * @date 2022, 5월 26일
 * @see https://www.acmicpc.net/problem/11653
 * @mem 11,884kb
 * @time 120ms
 * @caution
 * [고려사항]
 * 2부터 N까지의 수를 1씩 늘려가면서 나누어주어서 소인수분해를 하였다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <소수> '소인수분해'
public class BOJ11653 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=2;i<=N;i++) { // 2부터 N까지의 수를 1씩 늘려가면서 N과 나눠줘봄.
            for (;;) {
                if (N % i == 0) { // 딱 나눠진다면
                    N = N / i;
                    System.out.println(i);
                } else {
                    break;
                }
            }
        }
    }
}