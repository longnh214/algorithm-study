/**
 * @author nakhoonchoi
 * @date 2024/08/15
 * @see https://www.acmicpc.net/problem/11068
 * @mem 15,100kb
 * @time 96ms
 * @caution
 * [고려사항]
 * 진법 변환, 회문인 지 판별하는 함수를 사용해야했는데,
 * Integer.toString(number, radix) 함수에서 radix가 36이 넘어가면
 * 진법 변환이 제대로 동작하지 않는 이슈가 있었다.
 * 따라서 직접 진법 변환을 구현해야했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '회문인 수'

public class BOJ11068 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            boolean isPalindrome = false;
            int number = Integer.parseInt(br.readLine());

            for(int i=2;i<=64;i++){
                if(isPalindromeNum(convertToBaseSystem(number, i))){
                    isPalindrome = true;
                    break;
                }
            }

            System.out.println(isPalindrome ? 1 : 0);
        }
    }

    public static String convertToBaseSystem(int number, int base) {
        StringBuilder answer = new StringBuilder();
        while (number > 0) {
            int remainder = number % base;
            if (remainder < 10) {
                answer.append(remainder);
            } else {
                answer.append((char)('A' + remainder - 10));
            }
            number /= base;
        }
        return answer.toString();
    }

    public static boolean isPalindromeNum(String num){
        return new StringBuilder(num).toString().equals(new StringBuilder(num).reverse().toString());
    }
}