import java.util.*;
//프로그래머스 코딩테스트 연습 <스택/큐> - '쇠막대기' 문제
public class Programmers42585 {
    public static int solution(String arrangement) {
        int answer = 0;
        //temp 문자열에서 "()"는 레이저이므로 "|"로 치환해준다.
        String temp = arrangement.replace("()","|");
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < temp.length(); i++) {
            //'('이면 스택에 추가
            if (temp.charAt(i) == '(') {
                st.push(temp.charAt(i));
            }
            //')'이면 스택에서 '('를 빼면서 막대기가 하나 생김(+= 1)
            else if (temp.charAt(i) == ')') {
                st.pop();
                answer += 1;
            }
            //'|'이면 레이저이므로 스택에 들어있는 '('만큼 막대기가 생긴다.
            else{
                answer += st.size();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String str = "()(((()())(())()))(())";
        System.out.println(solution(str));
    }
}
