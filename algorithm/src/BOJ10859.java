/**
 * @author nakhoon
 * @date 2022, 7월 21일
 * @see https://www.acmicpc.net/problem/10859
 * @mem 11,492kb
 * @time 1,640ms
 * @caution
 * [고려사항]
 * 3,4,7이 들어있는 숫자를 확인하는 check 함수 안에 정규 표현식을 사용하려 했으나, 엣지 케이스가 있는 지 41%에서 WA를 받았고,
 * contains를 이용해서 풀었더니 AC를 맞을 수 있었다. 엣지 케이스가 궁금했던 문제이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <소수 판정> '뒤집어진 소수'
public class BOJ10859 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        if(isNotPrime(N)){
            System.out.println("no");
        }else{
            if (!check(String.valueOf(N))) System.out.println("no");
            else {
                long after = change(N);
                if (isNotPrime(after)) System.out.println("no");
                else System.out.println("yes");
            }
        }
    }

    public static boolean isNotPrime(long num){
        if(num == 1) return true;
        for(long i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0) return true;
        }
        return false;
    }

    public static boolean check(String s) {
        return !s.contains("3") && !s.contains("4") && !s.contains("7");
    }

    public static long change(long num) {
        long result = 0;
        while (num > 0) {
            if (num % 10 == 6) result = result * 10 + 9;
            else if (num % 10 == 9) result = result * 10 + 6;
            else
                result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}
