/**
 * @author nakhoon
 * @date 2022/07/18
 * @see https://www.acmicpc.net/problem/1436
 * @mem 158,624kb
 * @time 348ms
 * @caution
 * [고려사항]
 * 무한 반복문을 돌려서 num에 666이 포함될 때마다 count를 늘렸고, count가 N일 때 반복문을 탈출해서 해당 num 값을 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <구현> '영화감독 숌'
public class BOJ1436 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count = 0;
    int num = 0;
    while(count != N){
      num++;

      if(String.valueOf(num).contains("666")){
        count++;
      }
    }
    System.out.println(num);
  }
}