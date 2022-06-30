/**
 * @author nakhoon
 * @date 2022/06/30
 * @see https://www.acmicpc.net/problem/20922
 * @mem 37,424kb
 * @time 280ms =
 * @caution
 * [고려사항]
 * 투 포인터를 이용해서 문제를 해결할 수 있었다. 두 인덱스가 같을 경우에 더 진행하지 않고 끝나는 경우가 엣지 케이스로 존재했다.
 * 엣지 케이스를 몰랐다면 풀기 어려웠을 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투 포인터> '겹치는 건 싫어'
public class BOJ20922 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int [] countArr = new int[100001];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int [] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int left = 0;
    int right = 0;
    int answer = 0;
    countArr[arr[0]]++;
    while(right < N - 1 && left <= right){
      if(countArr[arr[right + 1]] < K){
        countArr[arr[right + 1]]++;
        right++;
        answer = Math.max(right - left + 1, answer);
      }else if(left == right) {
        countArr[arr[left]]--;
        left++;
        right++;
      }else{
        countArr[arr[left]]--;
        left++;
      }
    }
    System.out.println(answer);
  }
}