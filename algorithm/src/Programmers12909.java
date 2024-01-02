/**
 * @author nakhoon
 * @date 12/31/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 뒷 괄호가 나왔을 때, return false를 하는 조건으로 스택이 비어있는 지 외에 스택 중 맨 위를 확인하려했지만,
 * 굳이 확인할 필요가 없이 스택에는 앞 괄호만 들어갈 것이기 때문에 isEmpty()로만 조건을 주면 되는 문제였다.
 * (시간 초과 발생)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '올바른 괄호'
public class Programmers12909 {
    public static void main(String[] args) {
        String s = "(()(";
        System.out.println(solution(s));
    }

    private static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else if(s.charAt(i) == ')'){
//                if(!stack.isEmpty() && stack.peek() == '('){
//                    stack.pop();
//                }else{
//                    return false;
//                }
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}