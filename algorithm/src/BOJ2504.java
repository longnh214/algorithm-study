/**
 * @author choi
 * @date 2020. 7. 31
 * @see https://www.acmicpc.net/problem/2504
 * @mem 12,968kb
 * @time 80ms
 * @caution
 * [고려사항] 스택에서 뺄 때 더하기 처리를 어떻게 해야하나 생각했는데 temp 변수를
 *       이용하여 문제를 풀면 해결할 수 있었다.
 *       마지막에 값을 출력할 때 스택에 값이 있는 지 없는 지 확인을 해서
 *       스택에 값이 남아있다면 괄호가 안 맞는 것이므로 0을 넣어야 한다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 2504번 <스택> - '괄호의 값'
public class BOJ2504 {
    static Stack<Character> char_st = new Stack<>();
    public static void main(String[] args) throws IOException{
        // () = 2, [] = 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int temp = 1;
        int answer = 0;
        for(int i=0;i<str.length();i++) {
            switch(str.charAt(i)) {
                case '(':
                    //스택에 넣으면
                    char_st.push(str.charAt(i));
                    temp *= 2;
                    break;
                case '[':
                    char_st.push(str.charAt(i));
                    temp *= 3;
                    break;
                case ')':
                    if(char_st.isEmpty() ||char_st.peek() != '(') {
                        answer = 0;
                        break;
                    }
                    //자신의 짝 괄호가 바로 직전 인덱스에 있다면 answer+=temp를 한다.
                    if(str.charAt(i-1) == '(') answer += temp;
                    char_st.pop();
                    temp /= 2;
                    break;
                case ']':
                    if(char_st.isEmpty() || char_st.peek() != '[') {
                        answer = 0;
                        break;
                    }
                    if(str.charAt(i-1) == '[') answer += temp;
                    char_st.pop();
                    temp /= 3;
                    break;
            }
        }
        System.out.println(!char_st.isEmpty() ? 0 : answer);
    }
}