/**
 * @author nakhoon
 * @date 2022/06/23
 * @see https://www.acmicpc.net/problem/7785
 * @mem 47,984kb
 * @time 496ms
 * @caution
 * [고려사항]
 * TreeSet을 이용해서 문자열을 내림차순으로 정렬해서 문제를 해결할 수 있었다.
 * Set의 remove는 contains로 지울 객체가 있는 지 없는 지 판별할 필요가 없다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <자료구조> '회사에 있는 사람'
public class BOJ7785 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Set<String> memberSet = new TreeSet<>(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2) * -1;
      }
    });
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String member = st.nextToken();
      String command = st.nextToken();

      if(command.equals("enter")){
        memberSet.add(member);
      }else{
        memberSet.remove(member);
      }
    }

    StringBuilder sb = new StringBuilder();
    for(String member : memberSet){
      sb.append(member).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}