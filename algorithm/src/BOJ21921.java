/**
 * @author nakhoon
 * @date 2022/09/23
 * @see https://www.acmicpc.net/problem/21921
 * @mem 37,632kb
 * @time 292ms
 * @caution
 * [고려사항]
 * 누적 합, 슬라이딩 윈도우를 이용해서 문제를 해결할 수 있었다.
 * 배열 인덱스에 주의를 했던 문제.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <누적 합> '블로그'
public class BOJ21921 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());
    int [] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int max = 0;
    int count = 1;
    int cur = 0;

    for(int i=0;i<X;i++){
      max += arr[i];
    }
    cur = max;
    cur -= arr[0];


    for(int i=1;i<=N-X;i++){
      cur += arr[i+X-1];
      if(cur > max){
        max = cur;
        count = 1;
      }else if(cur == max){
        count++;
      }
      cur -= arr[i];
    }

    if(max > 0){
      System.out.println(max);
      System.out.println(count);
    }else{
      System.out.println("SAD");
    }
  }
}