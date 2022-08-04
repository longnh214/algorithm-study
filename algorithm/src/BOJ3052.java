/**
 * @author nakhoon
 * @date 2022/08/05
 * @see https://www.acmicpc.net/problem/3052
 * @mem 18,712kb
 * @time 240ms
 * @caution
 * [고려사항]
 * 자바 스트림 연습용으로 해결한 문제이다.
 * 반복해서 br.readLine()으로 입력받는 부분도 IntStream.range()를 이용해서 반복으로 처리하고 싶은데 어렵다...
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '나머지'
public class BOJ3052 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int [] num = new int[10];
    for(int i=0;i<10;i++){
      num[i] = Integer.parseInt(br.readLine());
    }
    System.out.println(Arrays.stream(num).map((i) -> i%42).distinct().count());
  }
}