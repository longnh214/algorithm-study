/**
 * @author nakhoon
 * @date 2022/06/12
 * @see https://www.acmicpc.net/problem/17427
 * @mem 11,792kb
 * @time 88ms
 * @caution
 * [고려사항]
 * N보다 작은 자연수마다 모든 약수의 합을 모두 합해서 구해야 했다.
 * 공식을 이용해서 합을 구할 수 있었다. 합계 변수를 long 형으로 선언해야하는 것에 주의해야 하는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '약수의 합 2'
public class BOJ17427 {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long ans = 0;

    for(int i=1;i<=N;i++) {
      ans += (N / i) * i;
    }

    System.out.println(ans);
  }
}