/**
 * @author nakhoon
 * @date 2022/06/28
 * @see https://www.acmicpc.net/problem/2635
 * @mem 16,680kb
 * @time 108ms
 * @caution
 * [고려사항]
 * N의 절반부터 N까지의 수를 두 번째 수로 둬야한다. N의 절반 아래로 둔다면 세 번째 수가 N의 절반보다 커져서 3으로 끝이나기 때문이다.
 * 1이 반례인데 1의 답은 1 1 0 1로 4이다. 반복문의 등호를 조심해야하는 문제.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '수 이어가기'
public class BOJ2635 {
  static int N,max;
  static List<Integer> answerList;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    for(int i=N/2;i<=N;i++){
      solve(i);
    }
    StringBuilder sb = new StringBuilder();
    sb.append(max).append("\n");
    for(int num : answerList){
      sb.append(num).append(" ");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }

  public static void solve(int i){
    List<Integer> list = new ArrayList<>();
    list.add(N);
    list.add(i);
    while(true){
      int a = list.get(list.size() - 2);
      int b = list.get(list.size() - 1);
      if(a - b >= 0)
        list.add(a - b);
      else
        break;
    }
    if(list.size() > max){
      answerList = new ArrayList<>(list);
      max = list.size();
    }
  }
}