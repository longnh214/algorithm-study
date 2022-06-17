/**
 * @author nakhoon
 * @date 2022/06/17
 * @see https://www.acmicpc.net/problem/17103
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 에라토스테네스의 체를 이용해서 소수를 미리 구하고, 입력 받은 수의 반까지 소수의 합으로 표현할 수 있는 지 판별해서 갯수를 더했습니다.
 * 주의해야할 점은 두 소수가 같은 소수여도 상관 없습니다. 다른 두 소수의 합이 아니라는 의미입니다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <소수 판정> '골드바흐 파티션'
public class BOJ17103 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    boolean [] isNotPrime = new boolean[1000001];
    for(int i=2;i<=Math.sqrt(1000001);i++){
      for(int j=i;i*j<1000001;j++){
        isNotPrime[j*i] = true;
      }
    }
    StringBuilder sb = new StringBuilder();
    while(N-->0){
      int count = 0;
      int target = Integer.parseInt(br.readLine());
      for(int i=2;i<=target/2;i++){
        if(isNotPrime[i]) continue;
        else if(!isNotPrime[target - i]){
          count++;
        }
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}