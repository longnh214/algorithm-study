/**
 * @author nakhoon
 * @date 2022/06/16
 * @see https://www.acmicpc.net/problem/5637
 * @mem 16,476kb
 * @time 140ms
 * @caution
 * [고려사항]
 * 한 줄 중의 가장 마지막 단어를 저장할 String과 정답 문자열을 저장할 String을 선언하고,
 * 정규식을 이용해 단어에 포함될 수 없는 문자는 제거하고 가장 긴 문자열을 출력했다.
 * E-N-D는 답에 포함될 수 없고, 가장 마지막 단어를 저장하려할 때 한 줄에 아무 문자열도 없어서 ArrayIndexBoundException을 조심해야했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <문자열> '가장 긴 단어'
public class BOJ5637 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String lastStr = "";
    String answer = "";

    while(!(lastStr.equals("E-N-D"))){
      String [] strArr = br.readLine().split(" ");

      for(String str : strArr){
        if(str.startsWith(" ") || str.length() == 0 || str.equals("E-N-D")) continue;
        str = str.replaceAll("[^A-Za-z\\-]","");
        answer = answer.length() < str.length() ? str : answer;
      }

      lastStr = strArr.length > 0 ? (strArr[strArr.length-1]) : lastStr;
    }
    System.out.println(answer.toLowerCase());
  }
}