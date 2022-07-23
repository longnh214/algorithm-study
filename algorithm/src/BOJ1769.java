/**
 * @author nakhoon
 * @date 2022/07/23
 * @see https://www.acmicpc.net/problem/1769
 * @mem 19,728kb
 * @time 168ms
 * @caution
 * [고려사항]
 * 재귀를 이용해서 문제를 해결했다. 3의 배수를 판별하는 함수와 재귀함수를 이용했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <문자열> '3의 배수'
public class BOJ1769 {
  static int count;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String inputNum = br.readLine();
    count = 0;
    System.out.println(getDigitSum(check(inputNum)) % 3 == 0 ? "YES" : "NO");
  }

  public static String check(String input){
    if(input.length() == 1){
      System.out.println(count);
      return input;
    }else{
      count++;
      return check(String.valueOf(getDigitSum(input)));
    }
  }

  public static int getDigitSum(String input){
    int sum = 0;
    for(int i=0;i<input.length();i++){
      char c = input.charAt(i);
      sum += (c - '0');
    }

    return sum;
  }
}