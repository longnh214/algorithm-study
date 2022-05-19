/**
 * @author nakhoon
 * @date 2022, 5월 19일
 * @see https://www.acmicpc.net/problem/12871
 * @mem 12,452kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 최대공약수를 구하고 A*B에서 A와 B의 최대공약수로 나누면 A와 B의 최소공배수가 나오는 공식을 이용해서
 * 최소공배수를 구하고 문자열을 최소공배수 길이로 반복해서 늘려서 비교한 뒤에 해결할 수 있었다.
 * 문자열을 늘릴 때 한 글자 씩 늘어나는 것은 처음 알았다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 <수학> '무한 문자열'
public class BOJ12871 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String A = a;
        String B = b;

        if(a.length() != b.length()){
            int len = LCM(a.length(), b.length());

            while(A.length() != len){
                A += a;
            }

            while(B.length() != len){
                B += b;
            }
        }

        System.out.println(A.equals(B) ? 1 : 0);
    }

    static int GCD(int a, int b){
        while(b > 0){
            int temp = a;
            a = b;
            b = temp%b;
        }

        return a;
    }

    static int LCM(int a, int b){
        return (a*b)/GCD(a,b);
    }
}