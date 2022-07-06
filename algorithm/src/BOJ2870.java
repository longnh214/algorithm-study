/**
 * @author nakhoon
 * @date 2022/07/06
 * @see https://www.acmicpc.net/problem/2870
 * @mem 14,104kb
 * @time 128ms
 * @caution
 * [고려사항]
 * 입력 과정에서 long 형으로 커버가 안되는 자료형의 수가 들어올 수 있기 때문에 BigInteger 클래스를 이용해서
 * 큰 수를 처리해야하는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.math.BigInteger;
import java.util.*;
import java.io.*;
//백준 <문자열> '수학숙제'
public class BOJ2870 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<BigInteger> pq = new PriorityQueue<>();
    while(N-->0){
      String [] input = br.readLine().split("[a-z ]");
      for(String str : input){
        if(!str.equals("")){
         pq.offer(new BigInteger(str));
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while(!pq.isEmpty()){
      sb.append(pq.poll()).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}