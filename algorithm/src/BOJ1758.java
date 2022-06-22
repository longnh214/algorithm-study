/**
 * @author nakhoon
 * @date 2022/06/22
 * @see https://www.acmicpc.net/problem/1758
 * @mem 22,944kb
 * @time 220ms
 * @caution
 * [고려사항]
 * 숫자를 내림차순으로 정렬한 뒤 문제를 해결하였다. 원래 주려던 팁 - (등수 - 1)이 음수라면 팁을 아예 안 주는(0)이어야 한다는 점에 주의해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '알바생 강호'
public class BOJ1758 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long answer = 0;
    List<Integer> list = new ArrayList<>();
    for(int i=0;i<N;i++){
      list.add(Integer.parseInt(br.readLine()));
    }
    Collections.sort(list, Collections.reverseOrder());
    for(int i=0;i<N;i++){
      answer += ((list.get(i) - i) < 0 ? 0 : (list.get(i) - i));
    }
    System.out.println(answer);
  }
}