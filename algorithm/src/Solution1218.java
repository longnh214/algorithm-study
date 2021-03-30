/**
 * @author choi
 * @date Jul 30, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE
 * @mem 18,700 kb
 * @time 106 ms
 * @caution
 * [고려사항] 매 테스트 케이스마다 스택 초기화를 해주어야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <D4> - '괄호 검사기'
public class Solution1218 {
    static int answer;
    static char [] str;
    public static void main(String[] args) throws IOException{
        Stack<Character> st = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1;t<=10;t++) {
            st.clear();
            answer = 1;
            //한 줄 지우기.
            br.readLine();
            //받은 문자열을 바로 char형 array로 변화.
            str = br.readLine().toCharArray();
            //'()', '[]', '{}', '<>'
            //스택을 참고해 짝이 맞지 않으면 answer을 0으로
            outer : for(int i=0;i<str.length;i++) {
                switch(str[i]) {
                    case '(':
                        st.push(str[i]);
                        break;
                    case '[':
                        st.push(str[i]);
                        break;
                    case '{':
                        st.push(str[i]);
                        break;
                    case '<':
                        st.push(str[i]);
                        break;
                    case ')':
                        if(st.pop() == '(')
                            break;
                        else {
                            answer = 0;
                            break outer;
                        }
                    case ']':
                        if(st.pop() == '[')
                            break;
                        else {
                            answer = 0;
                            break outer;
                        }
                    case '}':
                        if(st.pop() == '{')
                            break;
                        else {
                            answer = 0;
                            break outer;
                        }
                    case '>':
                        if(st.pop() == '<')
                            break;
                        else {
                            answer = 0;
                            break outer;
                        }
                }
            }
            //스택에 값이 남아있다면 괄호가 딱 맞는 것이 아니다.
            if(st.size() != 0) answer = 0;
            //아무런 문제가 없다면 answer은 1.
            System.out.println("#" + t + " " + answer);
        }
    }
}