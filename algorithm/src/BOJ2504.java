/**
 * @author nakhoon
 * @date Oct 2, 2021
 * @see https://www.acmicpc.net/problem/2504
 * @mem 11,488kb
 * @time 80ms
 * @caution
 * [고려사항]
 *  엣지케이스 ']()'에 대한 값 수정 잘못된 값(2) -> 맞는 값(0)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <스택> '괄호의 값'
public class BOJ2504 {
    static Stack<Character> char_st = new Stack<>();
    public static void main(String[] args) throws IOException{
        // () = 2, [] = 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int temp = 1;
        int answer = 0;
        outer: for(int i=0;i<str.length();i++) {
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
                       break outer;
                    }
                    if(str.charAt(i-1) == '(') answer += temp;
                    char_st.pop();
                    temp /= 2;
                    break;
                case ']':
                    if(char_st.isEmpty() || char_st.peek() != '[') {
                        answer = 0;
                        break outer;
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