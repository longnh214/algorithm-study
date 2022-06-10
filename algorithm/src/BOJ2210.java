/**
 * @author nakhoon
 * @date 2022/06/10
 * @see https://www.acmicpc.net/problem/2210
 * @mem 21,628kb
 * @time 136ms
 * @caution
 * [고려사항]
 * dfs를 이용해서 문제를 해결할 수 있었다. 대신 visited
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <DFS> '숫자판 점프'
public class BOJ2210 {
  static String [][] arr = new String[5][5];
  static Set<String> answerSet = new HashSet<>();
  static int [] dx = {-1,0,1,0};
  static int [] dy = {0,-1,0,1};

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    for(int i=0;i<5;i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0;j<5;j++){
        arr[i][j] = (st.nextToken());
      }
    }
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        //dfs
        dfs(i,j,0,"");
      }
    }
    System.out.println(answerSet.size());
  }

  public static boolean isIn(int x, int y){
    return x>=0 && x<5 && y>=0 && y<5;
  }

  public static void dfs(int x, int y, int count, String route){
    if(count == 6){
      answerSet.add(route);
      return;
    }

    for(int i=0;i<4;i++){
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(isIn(nx,ny)){
        dfs(nx,ny,count+1, route + arr[nx][ny]);
      }
    }
  }
}