/**
 * @author nakhoon
 * @date 2022/08/08
 * @see https://www.acmicpc.net/problem/11576
 * @mem 11,592kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 진수 변환 문제이다. 먼저 A진법으로 나타낸 수를 10진수로 변환한 뒤에, B진법으로 변환해서 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> 'Base Conversion'
public class BOJ11576 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    List<Integer> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    int A = Integer.parseInt(st.nextToken()); //미래
    int B = Integer.parseInt(st.nextToken()); //정이
    int m = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    // 10진수 변환
    int decimalNum = 0;
    for (int i = m; i > 0; i--) {
      int num = Integer.parseInt(st.nextToken());
      decimalNum += num * Math.pow(A, i - 1);
    }

    if(decimalNum == 0){
      sb.append(0);
    }
    // B진수로 변환
    while(decimalNum != 0){
      list.add(decimalNum % B);
      decimalNum/=B;
    }
    for (int i = list.size()-1; i >= 0; i--) {
      sb.append(list.get(i)).append(" ");
    }
    System.out.println(sb);
  }
}