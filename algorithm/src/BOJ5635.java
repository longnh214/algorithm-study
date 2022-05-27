/**
 * @author nakhoon
 * @date 2022/05/27
 * @see https://www.acmicpc.net/problem/5635
 * @mem 11,620kb
 * @time 72ms
 * @caution
 * [고려사항]
 * 연도, 월, 날짜를 기준으로 정렬을 하고, 나이가 가장 적은 사람과 많은 사람 순으로 이름을 출력하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '생일'
public class BOJ5635 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Info [] infoArr = new Info[N];
    StringTokenizer st;
    for(int i=0;i<N;i++){
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int day = Integer.parseInt(st.nextToken());
      int month = Integer.parseInt(st.nextToken());
      int year = Integer.parseInt(st.nextToken());
      infoArr[i] = new Info(name,day,month,year);
    }
    Arrays.sort(infoArr);
    StringBuilder sb = new StringBuilder();
    sb.append(infoArr[N-1].name).append("\n").append(infoArr[0].name);
    System.out.println(sb);
  }

  static class Info implements Comparable<Info>{
    String name;
    int day;
    int month;
    int year;

    Info(String name, int day, int month, int year){
      this.name = name;
      this.day = day;
      this.month = month;
      this.year = year;
    }

    @Override
    public int compareTo(Info o) {
      if(this.year == o.year){
        if(this.month == o.month){
          return Integer.compare(this.day, o.day);
        }
        return Integer.compare(this.month, o.month);
      }
      return Integer.compare(this.year, o.year);
    }
  }
}