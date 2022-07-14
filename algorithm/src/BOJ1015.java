/**
 * @author nakhoon
 * @date 2022/07/14
 * @see https://www.acmicpc.net/problem/1015
 * @mem 11,684kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 문제 내용이 잘 이해되지 않았는데, 겨우 이해해서 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '수열 정렬'
public class BOJ1015 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());

    List<Pair> list = new ArrayList<>();
    for(int i=0;i<N;i++){
      list.add(new Pair(i,Integer.parseInt(st.nextToken())));
    }

    Collections.sort(list);

    int[] p = new int[1001];
    for(int i=0;i<N;i++){
      p[list.get(i).index]=i;
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0;i<N;i++){
      sb.append(p[i]+" ");
    }

    System.out.println(sb.substring(0, sb.length()-1));
  }

  public static class Pair implements Comparable<Pair>{
    int index;
    int value;

    Pair(int index, int value){
      this.index = index;
      this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
      if(this.value<o.value){ // value 기준 오름차순
        return -1;
      }else if(this.value>o.value){
        return 1;
      }else{
        if(this.index <o.index){
          return -1;
        }else{
          return 1;
        }
      }
    }
  }
}