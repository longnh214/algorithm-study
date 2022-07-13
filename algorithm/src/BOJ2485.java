/**
 * @author nakhoon
 * @date 2022/07/13
 * @see https://www.acmicpc.net/problem/2485
 * @mem 21,868kb
 * @time 212ms
 * @caution
 * [고려사항]
 * 각 나무 길이의 차이를 배열에 저장하고, 맨 앞부터 유클리드 호제법으로 최대공약수를 구한 뒤에 나무의 그루 수를 구한 뒤에 N을 빼주면 심어야 할 나무의 그루 수를 계산할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '가로수'
public class BOJ2485 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] tree = new int[N];
    int [] diff = new int[N-1];
    for(int i=0;i<N;i++){
      tree[i] = Integer.parseInt(br.readLine());
      if(i > 0)
        diff[i-1] = tree[i] - tree[i-1];
    }
    for(int i=0;i<N-2;i++){
      diff[i+1] = gcd(diff[i],diff[i+1]);
    }
    int gap = diff[N-2];
    System.out.println((tree[N - 1] - tree[0]) / gap - (N - 1));
  }

  public static int gcd(int a, int b){
    while(b > 0){
      int temp = a;
      a = b;
      b = temp%b;
    }
    return a;
  }
}