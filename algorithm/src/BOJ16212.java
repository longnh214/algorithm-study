/**
 * @author nakhoon
 * @date 2022/06/06
 * @see https://www.acmicpc.net/problem/16212
 * @mem 111,984kb
 * @time 1,096ms
 * @caution
 * [고려사항]
 * BufferedReader와 StringBuilder를 이용하여 입출력을 진행하고, 배열 정렬을 통해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '정열적인 정렬'
public class BOJ16212 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<N;i++){
      sb.append(arr[i]).append(" ");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}