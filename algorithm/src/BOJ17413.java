/**
 * @author nakhoon
 * @date 2022/07/15
 * @see https://www.acmicpc.net/problem/17413
 * @mem 23,324kb
 * @time 212ms
 * @caution
 * [고려사항]
 * 스택과 StringBuilder를 이용해서 문제를 해결할 수 있었다. 각 문자에 대한 조건을 신경 써야하는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <자료구조> '단어 뒤집기 2'
public class BOJ17413 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    boolean flag = false;
    for(int i=0;i<input.length();i++){
      if(input.charAt(i) == '<'){
        while(!stack.isEmpty()){
          sb.append(stack.pop());
        }
        flag = true;
        sb.append(input.charAt(i));
      }else if(input.charAt(i) == '>'){
        flag = false;
        sb.append(input.charAt(i));
      }else if(input.charAt(i) == ' '){
        while(!stack.isEmpty()){
          sb.append(stack.pop());
        }
        sb.append(input.charAt(i));
      }else{
        if(!flag){
          stack.push(input.charAt(i));
        }else{
          sb.append(input.charAt(i));
        }
      }

    }
    while(!stack.isEmpty()){
      sb.append(stack.pop());
    }
    System.out.println(sb);
  }
}