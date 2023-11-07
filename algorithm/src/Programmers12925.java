/**
 * @author nakhoon
 * @date 11/7/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12925
 * @mem
 * @time
 * @caution
 * [고려사항] Integer.parseInt(string)을 이용해서 문자열을 변환하면 되는 문제이다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '문자열을 정수로 바꾸기'
public class Programmers12925 {
    public static int solution(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String s = "-1234";

        System.out.println(solution(s));
    }
}
