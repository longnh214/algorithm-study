/**
 * @author nakhoon
 * @date 2022/07/08
 * @see https://www.acmicpc.net/problem/15688
 * @mem 133,640kb
 * @time 18,392ms
 * @caution
 * [고려사항]
 * 테스트 케이스 전체 걸리는 시간이 30초 이내였던 문제이다.
 * 배열의 정렬을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '수 정렬하기 5'
public class BOJ15688 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] arr = new int[N];
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    for(int num : arr){
      sb.append(num).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}