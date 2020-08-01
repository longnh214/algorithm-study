/**
 * @author choi
 * @date 2020. 7. 31
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD
 * @mem 19,772kb
 * @time 154ms
 * @caution
 * [고려사항] 후위표기식으로 한번 바꾸고, 그 뒤에 int stack을 이용하여
 *         계산을 해야한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
// SW expert <D4> = '계산기2'
public class Solution1223 {
    public static void main(String[] args) throws IOException {
        Stack<Character> char_st = new Stack<Character>();
        Stack<Integer> int_st = new Stack<Integer>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            StringBuilder sb = new StringBuilder();
            br.readLine();
            String str = br.readLine();
            //중위 표기식을 후위표기식으로 바꾼다.
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                //피연산자라면 append.
                if ('0' <= c && c <= '9') {
                    sb.append(c);
                }
                //연산자라면 우선순위를 비교해서 처리.
                else {
                    while (!char_st.isEmpty() && priority(char_st.peek()) > priority(c)) {
                        sb.append(char_st.pop());
                    }
                    char_st.push(c);
                }
            }
            //연산자가 스택에 남아있을 수 있으므로 전부 pop.
            while (!char_st.isEmpty()) {
                sb.append(char_st.pop());
            }
            // 후위표기식으로 변환한 식
            String temp = sb.toString();
            //여기부터 계산.
            for (int i = 0; i < temp.length(); i++) {
                char c = temp.charAt(i);
                //숫자라면 숫자 스택에 push.
                if ('0' <= c && c <= '9') {
                    int_st.push(c - '0');
                }
                //여기부터 연산자 처리.
                else if (c == '+') {
                    int num1 = int_st.pop();
                    int num2 = int_st.pop();
                    int_st.push(num1 + num2);
                } else if (c == '*') {
                    int num1 = int_st.pop();
                    int num2 = int_st.pop();
                    int_st.push(num1 * num2);
                }
            }
            //스택에 남아있는 값이 계산 결과값이다.
            System.out.printf("#%d ",t);
            System.out.println(int_st.pop());
        }
    }
    //연산자 두 가지의 우선순위를 체크하는 함수.
    public static int priority(char c) {
        if (c == '+')
            return 1;
        else if (c == '*')
            return 2;
        else
            return 0;
    }
}