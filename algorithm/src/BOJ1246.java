/**
 * @author nakhoon
 * @date 2022/09/16
 * @see https://www.acmicpc.net/problem/1246
 * @mem 11,784kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 입력을 받고 가격 배열을 정렬한 뒤, 가격 배열의 값들을 접근하면서 해당 가격에 대해 얼마나 많은 수익을 낼 수 있는 지 계산했다.
 * 하나 고려해야할 점은 계란의 갯수가 N으로 한정되어있어 M-i 보다 N이 적다면 가격 * 계란의 갯수가 그 당시의 최대 수익이 될 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '온라인 판매'
public class BOJ1246 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int [] priceArr = new int[M];
    for(int i=0;i<M;i++){
      priceArr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(priceArr);
    int price = 0;
    int max = 0;
    int result = 0;
    for(int i=0;i<M;i++){
      if(M-i < N){
        result = priceArr[i] * (M-i);
      }else{
        result = priceArr[i] * N;
      }
      if(max < result){
        price = priceArr[i];
        max = result;
      }
    }
    System.out.println(price + " " + max);
  }
}