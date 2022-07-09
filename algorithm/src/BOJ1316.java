/**
 * @author nakhoon
 * @date 2022/07/09
 * @see https://www.acmicpc.net/problem/1316
 * @mem 11,492kb
 * @time 80ms
 * @caution
 * [고려사항]
 * check하는 함수를 만들고 각 알파벳 별로 visited 배열을 만들어서 방문했는 지 아닌 지 확인했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <구현> '그룹 단어 체커'
public class BOJ1316 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count = 0;
    for(int i=0;i<N;i++){
      String input = br.readLine();
      if(check(input)) count++;
    }
    System.out.println(count);
  }

  public static boolean check(String str){
    boolean [] visited = new boolean[26];
    char cur = '|';
    for(int i=0;i<str.length();i++){
      char c = str.charAt(i);
      if(cur != c){
        if(visited[c - 'a'])
          return false;
        cur = c;
        visited[c - 'a'] = true;
      }
    }
    return true;
  }
}