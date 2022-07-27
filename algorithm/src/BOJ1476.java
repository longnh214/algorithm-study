/**
 * @author nakhoon
 * @date 2022/07/27
 * @see https://www.acmicpc.net/problem/1476
 * @mem 11,452kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 단순하게 무한 반복문을 반복해서 각 나머지를 뺀 값을 15,28,19로 나눈 나머지가 0인 가장 최소의 수를 출력하면 되는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '날짜 계산'
public class BOJ1476 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int E = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int target = 1;
    while(true){
      if((target - E) % 15 == 0 && (target - S) % 28 == 0 && (target - M) % 19 == 0){
        break;
      }
      target++;
    }
    System.out.println(target);
  }
}