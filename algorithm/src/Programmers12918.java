/**
 * @author nakhoon
 * @date 11/30/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12918
 * @mem
 * @time
 * @caution
 * [고려사항] 정규 표현식을 이용해서 문제를 해결하였다. 문자열 길이에 대한 제한도 있었어서 한 번 틀렸다.
 * [입력사항]
 * [출력사항]
 */
import java.util.regex.Pattern;

//프로그래머스 <연습문제> '문자열 기본 다루기'
public class Programmers12918 {

    public static void main(String[] args) {
        System.out.println(solution("1234"));
        System.out.println(solution("a234"));
    }

    public static boolean solution(String s) {
        if(!(s.length() == 4 || s.length() == 6)) {
            return false;
        }
        // 정규 표현식: 숫자로만 이루어진 문자열
        String numericRegex = "\\d+";

        // 정규 표현식과 매치되면 true, 아니면 false 반환
        return Pattern.matches(numericRegex, s);
    }
}