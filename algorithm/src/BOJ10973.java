/**
 * @author nakhoon
 * @date 2022/07/24
 * @see https://www.acmicpc.net/problem/10973
 * @mem 13,416kb
 * @time 116ms
 * @caution
 * [고려사항]
 * 1. A[i-1] > A[i]를 만족하는 가장 큰 i를 찾는다.
 * 2. j >= i이면서 A[j] < A[i-1]를 만족하는 가장 큰 j를 찾는다.
 * 3. A[i-1]과 A[j]를 swap한다.
 * 4. A[i]부터 순열을 뒤집는다.
 *
 * 이 순서대로 구현했을 때 AC를 받을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> '이전 순열'
public class BOJ10973 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    System.out.println(prevPermutation(arr) ? -1 : printArr(arr));
  }

  public static String printArr(int [] arr){
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<arr.length;i++){
      sb.append(arr[i]).append(" ");
    }
    return sb.substring(0, sb.length()-1);
  }

  public static boolean prevPermutation(int [] arr){
    int N = arr.length;
    boolean flag = true;
    outer: for(int i=N-1;i>0;i--){
      if(arr[i-1]>arr[i]){
        for(int j=N-1;j>=i;j--){
          if(arr[j]<arr[i-1]){
            int temp = arr[i-1];
            arr[i-1] = arr[j];
            arr[j] = temp;
            int k = N-1;
            while(i < k){
              int temp2 = arr[i];
              arr[i] = arr[k];
              arr[k] = temp2;
              i++;
              k--;
            }
            flag = false;
            break outer;
          }
        }
      }
    }
    return flag;
  }
}