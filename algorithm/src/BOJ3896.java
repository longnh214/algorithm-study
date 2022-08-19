/**
 * @author nakhoon
 * @date 2022/08/19
 * @see https://www.acmicpc.net/problem/3896
 * @mem 13,772kb
 * @time 172ms
 * @caution
 * [고려사항]
 * 에라토스테네스의 체를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <소수 판정> '소수 사이 수열'
public class BOJ3896 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean [] isNotPrime = new boolean[1299710];
    for(int i=2;i<isNotPrime.length;i++){
      for(int j=i; i*j>2 && i*j<isNotPrime.length; j++){
        isNotPrime[i*j] = true;
      }
    }

    int T = Integer.parseInt(br.readLine());
    while(T-->0){
      int input = Integer.parseInt(br.readLine());
      if(isNotPrime[input]) {
        int s = input;
        int e = input;
        while(true) {
          if(!isNotPrime[--s]) break;
        }
        while(true) {
          if(!isNotPrime[++e]) break;
        }
        System.out.println(e-s);
      } else System.out.println(0);
    }
  }
}