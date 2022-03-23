/**
 * @author nakhoon
 * @date 2022, 3월 23일
 * @see https://www.acmicpc.net/problem/2749
 * @mem 23,476kb
 * @time 120ms
 * @caution
 * [고려사항]
 * https://sexycoder.tistory.com/62 를 참고하면 피보나치 수열을 K로 나누면 나머지가 똑같은 일정 주기가 있다고 하는데
 * 이것을 피사노 주기라고 한다. 피사노 지수를 150만으로 해서 나누고, N을 주기에 맞춰서 계산하고 피사노 지수보다 높다면 계속 피사노 지수로
 * 나눠주어서 배열의 값을 출력하면 정답을 출력할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <수학> '피보나치 수 3'
public class BOJ2749 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        int PISANO = 1500000;
        int MOD = 1000000;

        long [] arr = new long[PISANO];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<PISANO;i++){
            arr[i] = (arr[i-2] + arr[i-1]) % MOD;
        }

        if(N >= PISANO){
            N %= PISANO;
        }

        System.out.println(arr[(int)N]);
    }
}