/**
 * @author choi
 * @date 2020. 7. 31
 * @see https://www.acmicpc.net/problem/1918
 * @mem 12,984kb
 * @time 80ms
 * @caution
 * [고려사항] 연산자마다 우선순위를 지정해주어야한다.
 *       끝나도 스택에 남은 연산자가 있을 수 있음을 생각해주어야한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 1918번 <스택> - '후위 표기식'
public class BOJ1918 {
    static Stack<Character> operator = new Stack<Character>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            //피연산자면 append.
            if('A' <= c && c <= 'Z') {
                sb.append(c);
            }
            //여는 괄호면 스택에 push.
            else if(c == '(') {
                operator.push(c);
            }
            //닫는 괄호면 여는 괄호까지 스택에서 값을 뺀 후에 append.
            else if(c == ')') {
                while(!operator.isEmpty()) {
                    char op = operator.pop();
                    if(op == '(') break;
                    sb.append(op);
                }
            }
            //연산자인 경우. 우선순위를 판별해서 나보다 높은 우선순위는 pop 후 현재 연산자 push.
            else {
                while(!operator.isEmpty() && priority(operator.peek()) >= priority(c)) {
                    sb.append(operator.pop());
                }
                operator.push(c);
            }
        }
        while(!operator.isEmpty()) {
            sb.append(operator.pop());
        }
        System.out.println(sb.toString());
    }
    //해당 문자에 대한 우선순위를 출력하는 함수
    public static int priority(char c) {
        if(c == '(') return 0;
        else if(c == '+' || c == '-')
            return 1;
        else return 2;
    }
}