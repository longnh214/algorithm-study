/**
 * @author nakhoon
 * @date 2022/07/11
 * @see https://www.acmicpc.net/problem/2910
 * @mem 13,040kb
 * @time 104ms
 * @caution
 * [고려사항]
 * 각 숫자 별 개수와 첫 번째에 나온 인덱스를 전부 배열에서 관리하려했는데 메모리 초과가 발생했다.
 * 두 가지 모두 맵으로 관리했을 때 AC를 받을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '빈도 정렬'
public class BOJ2910 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Integer, Integer> firstIndexMap = new HashMap<>();
    Integer [] inputArr = new Integer[N];

    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      inputArr[i] = Integer.parseInt(st.nextToken());
      countMap.put(inputArr[i], countMap.getOrDefault(inputArr[i], 0) + 1);
      firstIndexMap.putIfAbsent(inputArr[i], i);
    }
    Arrays.sort(inputArr, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        if(countMap.get(o1) == countMap.get(o2)) return Integer.compare(firstIndexMap.get(o1), firstIndexMap.get(o2));
        return Integer.compare(countMap.get(o1), countMap.get(o2)) * -1;
      }
    });

    StringBuilder sb = new StringBuilder();
    for(int i=0;i<N;i++){
      sb.append(inputArr[i]).append(" ");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
}