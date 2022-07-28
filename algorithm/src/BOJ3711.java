/**
 * @author nakhoon
 * @date 2022/07/28
 * @see https://www.acmicpc.net/problem/3711
 * @mem 163,236kb
 * @time 680ms
 * @caution
 * [고려사항]
 * HashSet을 이용했을 때에는 중복 체크하는 로직이 있어서 그런지 메모리 초과가 발생했다.
 * ArrayList를 이용하고 바깥에서 중복 체크를 했을 때에 AC를 받을 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <수학> '학번'
public class BOJ3711 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    while(N-->0){
      int G = Integer.parseInt(br.readLine());
      int [] arr = new int[G];
      for(int i=0;i<G;i++){
        arr[i] = Integer.parseInt(br.readLine());
      }
      if(G == 1){
        System.out.println(1);
        continue;
      }
      int target = 2;

      while(true){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<G;i++){
          int MOD = arr[i] % target;
          if(list.contains(MOD)){
            break;
          }
          list.add(MOD);
        }
        if(list.size() == G){
          System.out.println(target);
          break;
        }
        target++;
      }
    }
  }
}