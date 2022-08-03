/**
 * @author nakhoon
 * @date 2022/08/03
 * @see https://www.acmicpc.net/problem/2577
 * @mem 18,480kb
 * @time 248ms
 * @caution
 * [고려사항]
 * 자바 8의 스트림 연습용으로 해결한 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '숫자의 개수'
public class BOJ2577 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int [] num = new int[10];
    int [] input = new int[3];

    for(int i=0;i<3;i++){
      input[i] = Integer.parseInt(br.readLine());
    }

    String output = String.valueOf(Arrays.stream(input).reduce(1, (a, b) -> a*b));

    output.chars().forEach(c -> num[c - '0']++);

    Arrays.stream(num).forEach(System.out::println);
    br.close();
  }
}