/**
 * @author nakhoon
 * @date 2022/06/29
 * @see https://www.acmicpc.net/problem/15904
 * @mem 12,068kb
 * @time 96ms
 * @caution
 * [고려사항]
 * 정규표현식을 이용해서 문제를 해결하였다. U 앞에도 문자가 있을 수 있다는 것을 고려해야 했던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//백준 <문자열> 'UCPC는 무엇의 약자일까?'
public class BOJ15904 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    Matcher m = Pattern.compile("^[a-zA-Z ]*U[a-zA-Z ]*C[a-zA-Z ]*P[a-zA-Z ]*C[a-zA-Z ]*$").matcher(input);

    System.out.println(m.matches() ? "I love UCPC" : "I hate UCPC");
  }
}