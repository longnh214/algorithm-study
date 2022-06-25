/**
 * @author nakhoon
 * @date 2022/06/25
 * @see https://www.acmicpc.net/problem/2828
 * @mem 11,500kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 문제가 잘 이해가지 않았던 문제이다. 처음 초기 설정은 맨 왼쪽부터 M칸을 차지하는 바구니가 있어서, M이 2이면
 * 1과 2, 두 칸이 커버 가능한 바구니라는 뜻이다. 최소 이동 거리를 계산할 함수를 만들어서 해결했다. 이동 거리는 절댓값으로 계산해야하는 점을 주의해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '사과 담기 게임'
public class BOJ2828 {
  static int min, max;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int count = Integer.parseInt(br.readLine());
    int answer = 0;
    min = 1;
    max = M;
    for(int i=0;i<count;i++){
      int point = Integer.parseInt(br.readLine());
      int moveCount = move(point);
      answer += Math.abs(moveCount);
      min += moveCount;
      max += moveCount;
    }

    System.out.println(answer);
  }

  public static int move(int point){
    int output = 0;
    if(point >= min && point <= max){
      return output;
    }else if(point < min){
      return (point - min);
    }else {
      return (point - max);
    }
  }
}