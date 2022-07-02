/**
 * @author nakhoon
 * @date 2022/07/02
 * @see https://www.acmicpc.net/problem/2822
 * @mem 11,476kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 정렬을 내림차순으로 한 번, 오름차순으로 한 번 총 두 번으로 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '점수 계산'
public class BOJ2822 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Data [] arr = new Data[8];
    for(int i=0;i<8;i++){
      arr[i] = new Data(i, Integer.parseInt(br.readLine()));
    }
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    int sum = 0;
    int [] indexArr = new int[5];
    for(int i=0;i<5;i++){
      sum += arr[i].amount;
      indexArr[i] = arr[i].index+1;
    }
    sb.append(sum).append("\n");
    Arrays.sort(indexArr);
    for(int i=0;i<5;i++){
      sb.append(indexArr[i]).append(" ");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }

  static class Data implements Comparable<Data>{
    int index;
    int amount;

    Data(int index, int amount){
      this.index = index;
      this.amount = amount;
    }

    @Override
    public int compareTo(Data o) {
      return Integer.compare(this.amount, o.amount) * -1;
    }
  }
}