/**
 * @author nakhoon
 * @date 2022/08/16
 * @see https://www.acmicpc.net/problem/11441
 * @mem 56,624kb
 * @time 620ms
 * @caution
 * [고려사항]
 * 입력 받으면서 배열에 처음부터 해당 인덱스까지의 값을 누적 합 해서 저장하고,
 * (두 번째 입력값을 인덱스로 하는 누적 합 - 첫 번째 입력값에서 1을 뺀 인덱스로 하는 누적 합) 공식으로 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <누적 합> '합 구하기'
public class BOJ11441 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] arr = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1;i<=N;i++){
      arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
    }
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while(T-->0){
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());

      sb.append(arr[second] - arr[first - 1]).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}