/**
 * @author nakhoon
 * @date 2022/06/05
 * @see https://www.acmicpc.net/problem/16171
 * @mem 11,644kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 정규 표현식에 의해 숫자를 공백으로 치환하고, 기준 문자열이 포함되어있는 지를 확인했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <문자열> '나는 친구가 적다 (Small)'
public class BOJ16171 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String standard = br.readLine();
    input = input.replaceAll("[0-9]","");
    System.out.println(input.contains(standard) ? 1 : 0);
  }
}