/**
 * @author nakhoon
 * @date 1/6/24
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12973
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 스택을 이용해서 선형으로 탐색할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '짝지어 제거하기'
public class Programmers12973 {

    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }

    public static int solution(String s){
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }


        }
        return stack.isEmpty() ? 1 : 0;
    }
}
