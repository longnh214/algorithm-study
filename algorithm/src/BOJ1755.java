/**
 * @author nakhoon
 * @date 2022/07/07
 * @see https://www.acmicpc.net/problem/1755
 * @mem 11,820kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 출력 형식을 잘못 생각해서 한번 틀린 문제이다.
 * 한 줄에 10개씩 출력해야하는 것을 보지 못했었다.
 * 각 숫자들을 문자열로 변환해서 문자열 기준으로 정렬하는 Comparator를 구현해서 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '숫자놀이'
public class BOJ1755 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Integer [] arr = new Integer[M-N+1];
    for(int i=0;i<arr.length;i++){
      arr[i] = N + i;
    }

    Map<Integer, String> map = new HashMap<>();
    map.put(1, "one");
    map.put(2, "two");
    map.put(3, "three");
    map.put(4, "four");
    map.put(5, "five");
    map.put(6, "six");
    map.put(7, "seven");
    map.put(8, "eight");
    map.put(9, "nine");
    map.put(0, "zero");

    Arrays.sort(arr, new Comparator<Integer>(){
      @Override
      public int compare(Integer o1, Integer o2) {
        String str1 = String.valueOf(o1);
        String str2 = String.valueOf(o2);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str1.length();i++){
          sb.append(map.get(str1.charAt(i) - '0')).append(" ");
        }
        String output1 = sb.substring(0, sb.length()-1);

        sb = new StringBuilder();
        for(int i=0;i<str2.length();i++){
          sb.append(map.get(str2.charAt(i) - '0')).append(" ");
        }
        String output2 = sb.substring(0, sb.length()-1);

        return output1.compareTo(output2);
      }
    });

    StringBuilder sb = new StringBuilder();
    int count = 0;
    for(int num : arr){
      if(count == 10){
        sb = new StringBuilder(sb.substring(0, sb.length() - 1));
        sb.append("\n");
        count = 0;
      }
      sb.append(num).append(" ");
      count++;
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}