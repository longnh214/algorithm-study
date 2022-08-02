/**
 * @author nakhoon
 * @date 2022/08/02
 * @see https://www.acmicpc.net/problem/14468
 * @mem 11,448kb
 * @time 84ms
 * @caution
 * [고려사항]
 * A의 시작점 < B의 시작점, B의 시작점 < A의 끝점, A의 끝점 < B의 끝점을 만족하는 A와 B의 쌍을 찾으면 문제를 해결할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <문자열> '소가 길을 건너간 이유 2'
public class BOJ14468 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int [] pos1 = new int[26];
    int [] pos2 = new int[26];
    for(int i=0;i<52;i++){
      int alpha = str.charAt(i) - 'A';
      if(pos1[alpha] == 0){
        pos1[alpha] = i+1;
      }else{
        pos2[alpha] = i+1;
      }
    }
    int count = 0;
    for(int i=0;i<26;i++){
      for(int j=0;j<26;j++){
        if(pos1[i] < pos1[j] && pos1[j] < pos2[i] && pos2[i] < pos2[j])
          count++;
      }
    }
    System.out.println(count);
  }
}