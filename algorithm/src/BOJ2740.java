/**
 * @author nakhoon
 * @date 2022/08/01
 * @see https://www.acmicpc.net/problem/2740
 * @mem 14,336kb
 * @time 140ms
 * @caution
 * [고려사항]
 * 기본 교육 과정에서 배웠던 행렬의 곱셈을 코드로 구현하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '행렬 곱셈'
public class BOJ2740 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] A = new int[N][M];

    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());

    // B행렬 입력
    st.nextToken();		// 어차피 M값으로 같은 수이기 때문에 버려도 상관 없다.
    int K = Integer.parseInt(st.nextToken());

    int[][] B = new int[M][K];

    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < K; j++) {
        B[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < K; j++) {
        int sum = 0;
        for(int k = 0; k < M; k++) {
          sum += A[i][k] * B[k][j];
        }
        sb.append(sum).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}