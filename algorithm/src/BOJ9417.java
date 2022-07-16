/**
 * @author nakhoon
 * @date 2022/07/16
 * @see https://www.acmicpc.net/problem/9417
 * @mem 11,572kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 경우의 수가 최대 100C2이기 때문에 dfs로 경우의 수를 찾고, 모든 경우의 수에 대해 최대공약수(GCD)를 구해서
 * 그 중 가장 큰 값을 출력하면 되었다.
 * 문자열을 입력받을 때에는 StringTokenizer의 countTokens를 이용했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '최대 GCD'
public class BOJ9417 {
  static int [] arr;
  static int [] temp;
  static int max;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      arr = new int[st.countTokens()];
      temp = new int[2];
      max = 0;
      for(int j=0;j<arr.length;j++){
        arr[j] = Integer.parseInt(st.nextToken());
      }
      dfs(0,0);
      sb.append(max).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }

  public static void dfs(int start, int count){
    if(count == 2){
      max = Math.max(max, GCD(temp[0],temp[1]));
      return;
    }

    for(int i=start;i<arr.length;i++){
      temp[count] = arr[i];
      dfs(i+1,count+1);
    }
  }

  public static int GCD(int a, int b){
    while(b > 0){
      int temp = a;
      a = b;
      b = temp%b;
    }

    return a;
  }
}