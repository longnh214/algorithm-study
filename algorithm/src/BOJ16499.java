/**
 * @author nakhoon
 * @date 2022/07/04
 * @see https://www.acmicpc.net/problem/16499
 * @mem 11,548kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 입력 받은 문자열들을 char 배열로 변환 후 정렬하고, 그 값을 set에 넣음으로서 set의 총 크기를 출력하면 되는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <자료구조> '동일한 단어 그룹화하기'
public class BOJ16499 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();
    while(N-->0){
      char [] inputArr = br.readLine().toCharArray();

      Arrays.sort(inputArr);

      String str = String.valueOf(inputArr);
      set.add(str);
    }
    System.out.println(set.size());
  }
}