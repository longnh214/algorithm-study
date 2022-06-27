/**
 * @author nakhoon
 * @date 2022/06/27
 * @see https://www.acmicpc.net/problem/18310
 * @mem 38,272kb
 * @time 356ms
 * @caution
 * [고려사항]
 * 숫자 배열을 정렬하고, 그 중간 값을 출력하면 된다. 배열 원소의 개수가 짝수일 때, 홀수 일 때를 나누어서 구해야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '안테나'
public class BOJ18310 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int [] arr = new int[N];
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    System.out.println(N % 2 == 0 ? arr[N/2 - 1] : arr[N/2]);
  }
}