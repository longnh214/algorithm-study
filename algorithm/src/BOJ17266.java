/**
 * @author nakhoon
 * @date 2022/06/24
 * @see https://www.acmicpc.net/problem/17266
 * @mem 25,372kb
 * @time 252ms
 * @caution
 * [고려사항]
 * 구현 식으로 하나씩 불을 밝히면서 최소 가로등 높이를 구하려고 했는데 시간 초과가 발생했다.
 * 0부터 N(굴다리의 길이) 중에서 이분 탐색을 진행해서 굴다리를 다 덮는 높이를 찾아야 하는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <이분탐색> '어두운 굴다리'
public class BOJ17266 {
  static int N,M;
  static int [] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = null;
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());

    int[] lamp = new int[m];

    for (int i = 0; i < m; i++)
      lamp[i] = Integer.parseInt(st.nextToken());

    binary_search(lamp, n);
  }

  private static void binary_search(int[] lamp, int n) {
    int left = 0;
    int right = n;
    int mid = 0;
    while (left < right) {
      mid = (left + right) / 2;

      if(isLightCovered(lamp,mid,n)) {
        right = mid; //덮는 경우
      }else { //못 덮는 경우
        left = mid+1;
      }
    }

    System.out.println(left);
  }

  private static boolean isLightCovered(int[] lamp, int height, int n) {
    int start =0;
    for (int i = 0; i < lamp.length; i++) {
      int left = lamp[i] - height;
      int right = lamp[i] + height;

      if(start < left)
        return false;
      else
        start = right;
    }

    if(n - start > 0)
      return false;
    return true;
  }
}