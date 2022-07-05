/**
 * @author nakhoon
 * @date 2022/07/05
 * @see https://www.acmicpc.net/problem/20291
 * @mem 91,392kb
 * @time 720ms
 * @caution
 * [고려사항]
 * TreeMap을 이용해서 문제를 해결할 수 있었다. <String, Set<String>> 으로 문제를 해결하려 했으나 틀렸다.
 * <String, Integer>로 확장자에 대한 파일의 개수만으로 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <자료구조> '파일 정리'
public class BOJ20291 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Map<String, Integer> map = new TreeMap<>();
    while(N-->0){
      String [] input = br.readLine().split("\\.");
      String key = input[1];
      map.put(key, map.getOrDefault(key, 0) + 1);
    }

    StringBuilder sb = new StringBuilder();
    for(String key : map.keySet()){
      sb.append(key).append(" ").append(map.get(key)).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}