/**
 * @author nakhoonchoi
 * @date 2024/08/17
 * @see https://www.acmicpc.net/problem/13277
 * @mem 369,752kb
 * @time 5,452ms
 * @caution
 * [고려사항]
 * BigInteger 클래스를 이용해서 큰 수 곱셈을 구하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//백준 <수학> '큰 수 곱셈'

public class BOJ13277 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger num1 = new BigInteger(st.nextToken());
        BigInteger num2 = new BigInteger(st.nextToken());

        System.out.println(num1.multiply(num2));
    }
}