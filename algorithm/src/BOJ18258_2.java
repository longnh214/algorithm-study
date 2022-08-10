/**
 * @author nakhoon
 * @date 2022/08/10
 * @see https://www.acmicpc.net/problem/18258
 * @mem 323,760kb
 * @time 1,064ms
 * @caution
 * [고려사항]
 * 평소 StringBuilder를 출력할 때, sb.substring(0, sb.length()-1)을 출력하는 습관이 있는데, 아무 것도 없는 출력이 있는 경우
 * StringIndexOutOfBoundsException이 발생하는 문제가 있어서 수정했다.
 * 덱(Deque) 라이브러리를 사용하는 방식으로 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <자료구조> '큐 2'
public class BOJ18258_2 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    Deque<Integer> q = new ArrayDeque<>();
    for(int i=0;i<N;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();

      switch(cmd){
        case "push":
          int num = Integer.parseInt(st.nextToken());
          q.offer(num);
          break;
        case "front":
          sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
          break;
        case "back":
          sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
          break;
        case "size":
          sb.append(q.size()).append("\n");
          break;
        case "empty":
          sb.append(q.isEmpty() ? 1 : 0).append("\n");
          break;
        case "pop":
          sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
          break;
        default:
          break;
      }
    }
    System.out.println(sb);
  }
}