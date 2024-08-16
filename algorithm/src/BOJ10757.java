/**
 * @author nakhoonchoi
 * @date 2024/08/16
 * @see https://www.acmicpc.net/problem/10757
 * @mem 15,072kb
 * @time 164ms
 * @caution
 * [고려사항]
 * BigInteger 클래스를 이용해서 큰 수 더하기를 구하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.math.BigInteger;
import java.util.*;
//백준 <수학> '큰 수 A+B'

public class BOJ10757 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger num1 = new BigInteger(st.nextToken());
        BigInteger num2 = new BigInteger(st.nextToken());

        System.out.println(num1.add(num2));
    }
}