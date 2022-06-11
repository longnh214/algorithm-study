/**
 * @author nakhoon
 * @date 2022/06/11
 * @see https://www.acmicpc.net/problem/1343
 * @mem 11,520kb
 * @time 92ms
 * @caution
 * [고려사항]
 * '.' 사이의 X 개수가 홀수이면 -1을 출력하고, 짝수이면 최대한 AAAA를 채우고 나머지를 BB를 채우는 식으로 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <그리디> '폴리오미노'
public class BOJ1343 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for(int i=0;i<str.length();i++){
      if(str.charAt(i) == 'X'){
        count++;
      }else{
        if(count % 2 == 1) {
          sb = new StringBuilder();
          sb.append("-1");
          break;
        }

        while(count != 0){
          if(count >= 4){
            sb.append("AAAA");
            count -= 4;
          }else{
            sb.append("BB");
            count -= 2;
          }
        }
        sb.append(".");

      }
    }
    if(count > 0){
      if(count % 2 == 1) {
        sb = new StringBuilder();
        sb.append("-1");
      }else{
        while(count != 0){
          if(count >= 4){
            sb.append("AAAA");
            count -= 4;
          }else{
            sb.append("BB");
            count -= 2;
          }
        }
      }
    }
    System.out.println(sb);
  }
}