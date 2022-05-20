/**
 * @author nakhoon
 * @date 2022/05/20
 * @see https://www.acmicpc.net/problem/1935
 * @mem 11,840kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 소수점 둘째짜리까지 출력해야하므로 double 형을 이용했고, 후위 표기식을 처리하기 위해 Stack 자료구조를 이용했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <자료구조> '후위 표기식2'
public class BOJ1935 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String expression = br.readLine();
    int [] num = new int[N];
    for(int i=0;i<N;i++){
      num[i] = Integer.parseInt(br.readLine());
    }

    Stack<Double> stack = new Stack<>();
    for(int i=0;i<expression.length();i++){
      char ch = expression.charAt(i);
      if(ch >= 'A' && ch <= 'Z'){
        double d = num[ch - 'A'];
        stack.push(d);
      }else {
        double d1 = stack.pop();
        double d2 = stack.pop();
        double d3 = 0.0;
        switch(ch){
          case '+':
            d3 = d2 + d1;
            break;
          case '-':
            d3 = d2 - d1;
            break;
          case '*':
            d3 = d2 * d1;
            break;
          case '/':
            d3 = d2 / d1;
            break;
        }
        stack.push(d3);
      }
    }
    System.out.printf("%.2f", stack.pop());
  }
}