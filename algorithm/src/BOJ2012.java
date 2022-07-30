/**
 * @author nakhoon
 * @date 2022/07/30
 * @see https://www.acmicpc.net/problem/2012
 * @mem 49,444kb
 * @time 524ms
 * @caution
 * [고려사항]
 * | a - b | = 0 이 나올 수 있는, 정해진 등수에 바로 들어갈 수 있는 경우의 수는 제외하고,
 * 예상 등수와 맞을 수 없는 나머지 등수들의 차를 절댓값으로 해서 합 계산을 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '등수 매기기'
public class BOJ2012 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    boolean [] check = new boolean[500001];
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int i=0;i<N;i++){
      int grade = Integer.parseInt(br.readLine());
      if(grade <= N && !check[grade]){
        check[grade] = true;
      }else{
        pq.offer(grade);
      }
    }
    long answer = 0;
    for(int i=1;i<=N;i++){
      if(!check[i]){
        answer += Math.abs(pq.poll() - i);
      }
    }
    System.out.println(answer);
  }
}