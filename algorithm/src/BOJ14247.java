/**
 * @author nakhoon
 * @date 2022, 3월 10일
 * @see https://www.acmicpc.net/problem/14247
 * @mem 29,084kb
 * @time 392ms
 * @caution
 * [고려사항]
 * 그리디하게 풀어야 했던 문제이다. 규칙을 찾기 어려웠다. 맨처음 나무 길이는 고정으로 생각하고, 자라는 속도에만 신경을 쓰면 되었다.
 * 먼저, 모든 초기 나무의 길이를 더하고 자라는 속도를 오름차순 정렬해서 grow[i] * i 만큼 계속 더해주면 정답이 나오게 된다.
 * 여기에서 answer 값은 long 형 크기까지 늘어날 수 있으므로 조심해야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디> '나무 자르기'
public class BOJ14247 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    Tree [] trees = new Tree[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      trees[i] = new Tree(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0;i<N;i++){
      trees[i].grow = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(trees);

    long answer = 0;
    for(int i=0;i<N;i++){
      answer += ((trees[i].length) + (i * trees[i].grow));
    }
    System.out.println(answer);
  }

  static class Tree implements Comparable<Tree>{
    int length;
    int grow;

    Tree(int length){
      this.length = length;
    }

    @Override
    public int compareTo(Tree o) {
      return Integer.compare(this.grow, o.grow);
    }
  }
}