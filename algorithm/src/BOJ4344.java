/**
 * @author nakhoon
 * @date 2022/08/04
 * @see https://www.acmicpc.net/problem/4344
 * @mem 23,816kb
 * @time 388ms
 * @caution
 * [고려사항]
 * printf를 통해서 %를 출력할 때 "%%"를 넣어야 %가 나오는 것을 찾아야 했던 문제이다.
 * 스트림을 최대한 이용해봤는데 어려웠다.
 * 배열 스트림 중에 특정 인덱스부터 배열에 추가할 수 있는 오버로딩 stream 메소드가 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '평균은 넘겠지'
public class BOJ4344 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while(T-->0){
      String [] input = br.readLine().split(" ");
      int count = Integer.parseInt(input[0]);
      int [] num = Arrays.stream(input, 1, input.length).mapToInt(Integer::parseInt).toArray();
      int targetCount = Arrays.stream(num).filter(score -> score > (int) Arrays.stream(num).average().getAsDouble()).toArray().length;
      System.out.printf("%.3f%%\n", ((double)(targetCount * 100) / count));
    }
  }
}