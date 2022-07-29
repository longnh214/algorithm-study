/**
 * @author nakhoon
 * @date 2022/07/29
 * @see https://www.acmicpc.net/problem/9322
 * @mem 36,388kb
 * @time 332ms
 * @caution
 * [고려사항]
 * 문자열의 인덱스를 저장하는 해시맵과 인덱스의 변환을 관리하는 해시맵 총 두 해시맵을 이용해서 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <자료구조> '철벽 보안 알고리즘'
public class BOJ9322 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    while(T-->0){
      int N = Integer.parseInt(br.readLine());
      Map<String, Integer> strMap = new HashMap<>();
      Map<Integer, Integer> indexMap = new HashMap<>();
      st = new StringTokenizer(br.readLine());
      String [] target = new String[N];
      for(int i=0;i<N;i++){
        strMap.put(st.nextToken(), i);
      }
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
        String str = st.nextToken();
        indexMap.put(strMap.get(str), i);
      }
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
        target[i] = st.nextToken();
      }

      StringBuilder sb = new StringBuilder();
      for(int i=0;i<N;i++){
        sb.append(target[indexMap.get(i)]).append(" ");
      }
      System.out.println(sb.substring(0, sb.length()-1));
    }
  }
}