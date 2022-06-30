/**
 * @author nakhoon
 * @date 2022/07/01
 * @see https://www.acmicpc.net/problem/11931
 * @mem 160,404kb
 * @time 1,400ms
 * @caution
 * [고려사항]
 * 내림차순으로 정렬하기 위해 Collections.sort()를 이용해서 정렬하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '수 정렬하기 4'
public class BOJ11931 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<N;i++){
      list.add(Integer.parseInt(br.readLine()));
    }
    Collections.sort(list, Collections.reverseOrder());
    StringBuilder sb = new StringBuilder();
    for(int num : list){
      sb.append(num).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}