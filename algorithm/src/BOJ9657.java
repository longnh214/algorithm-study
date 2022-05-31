/**
 * @author nakhoon
 * @date 2022/05/31
 * @see https://www.acmicpc.net/problem/9657
 * @mem 11,512kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 7을 기준으로 누가 이기고 지는 지 규칙이 반복되기 때문에 이를 이용해서 문제를 해결 할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <게임 이론> '돌 게임 3'
public class BOJ9657 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    System.out.println(N % 7 == 0 || N % 7 == 2 ? "CY" : "SK");
  }
}