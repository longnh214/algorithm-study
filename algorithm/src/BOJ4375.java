/**
 * @author nakhoon
 * @date 2022/08/11
 * @see https://www.acmicpc.net/problem/4375
 * @mem 11,392kb
 * @time 72ms
 * @caution
 * [고려사항]
 * 처음에는 매번 10을 곱해주고 1을 더하는 방식으로 1을 추가해서 나머지를 구했더니 시간 초과가 발생했고,
 * 10A + 1을 num으로 나눈 나머지에서 10을 곱해주고 1을 더한 값을 num으로 나눠도 나머지가 같기 때문에
 * multiplyer = (multiplyer * 10 + 1) % num; 을 진행한 횟수를 출력하면 정답이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '1'
public class BOJ4375 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    int count;
    while ((input = br.readLine()) != null) {
      int num = Integer.parseInt(input);
      int multiplyer = 1;
      count = 1;

      while (multiplyer % num != 0) {
        multiplyer = (multiplyer * 10 + 1) % num;
        count++;
      }
      System.out.println(count);
    }
  }
}