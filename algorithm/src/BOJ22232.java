/**
 * @author nakhoon
 * @date 2022/07/31
 * @see https://www.acmicpc.net/problem/22232
 * @mem 156,264kb
 * @time 1,844ms
 * @caution
 * [고려사항]
 * 파일의 각 정보를 입력받고, 조건 별로 나누어서 정렬 인터페이스를 상속받았다.
 * 파일 객체 안에 파일 탐색기가 알고 있는 확장자인가 아닌가를 미리 1자리 숫자로 넣어주었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '가희와 파일 탐색기'
public class BOJ22232 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    String [] strArr = new String[N];
    File [] fileArr = new File[N];
    Set<String> extSet = new HashSet<>();
    for(int i=0;i<N;i++){
      strArr[i] = br.readLine();
    }
    for(int i=0;i<M;i++){
      extSet.add(br.readLine());
    }
    for(int i=0;i<N;i++){
      String [] input = strArr[i].split("\\.");
      String name = input[0];
      String extension = input[1];
      int isKnown = extSet.contains(extension) ? 1 : 0;
      fileArr[i] = new File(name, extension, isKnown);
    }
    Arrays.sort(fileArr);

    StringBuilder sb = new StringBuilder();
    for(File file : fileArr){
      sb.append(file.name).append(".").append(file.extension).append("\n");
    }
    System.out.println(sb.substring(0, sb.length()-1));
  }
  static class File implements Comparable<File>{
    String name;
    String extension;
    int isKnown;

    File(String name, String extension, int isKnown){
      this.name = name;
      this.extension = extension;
      this.isKnown = isKnown;
    }

    @Override
    public int compareTo(File o) {
      if(this.name.equals(o.name)){
        if(this.isKnown == o.isKnown){
          return this.extension.compareTo(o.extension);
        }
        return Integer.compare(this.isKnown, o.isKnown) * -1;
      }
      return this.name.compareTo(o.name);
    }
  }
}