/**
 * @author nakhoon
 * @date 2022/08/06
 * @see https://www.acmicpc.net/problem/1546
 * @mem 19,416kb
 * @time 268ms
 * @caution
 * [고려사항]
 * 자바 스트림 연습용으로 해결한 문제이다.
 * 공통화 하기 위해 변수에 저장했지만 최대한 스트림을 이용해서 가독성을 높이려고 노력했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '평균'
public class BOJ1546 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    int [] score = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int max = Arrays.stream(score).max().getAsInt();
    double average = Arrays.stream(score).mapToDouble((i) -> ((double)i * 100) / max).average().getAsDouble();
    System.out.println(average);
  }
}