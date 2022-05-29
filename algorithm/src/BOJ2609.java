/**
 * @author nakhoon
 * @date 2022/05/29
 * @see https://www.acmicpc.net/problem/2609
 * @mem 11,496kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 두 수의 곱 / 최대공약수 = 최소공배수의 공식을 이용해서 최대공약수와 최소공배수를 출력하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '최대공약수와 최소공배수'
public class BOJ2609 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    System.out.println(GCD(N,M));
    System.out.println(LCM(N,M));
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