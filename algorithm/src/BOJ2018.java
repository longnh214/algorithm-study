/**
 * @author nakhoon
 * @date 2022/07/03
 * @see https://www.acmicpc.net/problem/2018
 * @mem 11,644kb
 * @time 132ms
 * @caution
 * [고려사항]
 * 연속된 숫자의 합의 가지수를 구하는 문제여서 자기 숫자 하나만 해당하는 부분은 가지수로 계산 안하는 줄 알았다.
 * 문제를 잘 읽어야한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <투 포인터> '수들의 합 5'
public class BOJ2018 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int target = Integer.parseInt(br.readLine());
    int count = 0;
    if(target < 3) {
      System.out.println(1);
      return;
    }
    int left = 1;
    int right = 2;
    int sum = 3;

    while(left <= right){
      if(target < sum){
        sum -= left;
        left++;
      }else if(target == sum){
        count++;
        sum -= left;
        left++;
      }else{
        right++;
        sum += right;
      }
    }
    System.out.println(count);
  }
}