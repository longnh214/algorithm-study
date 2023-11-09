/**
 * @author nakhoon
 * @date 11/10/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12937
 * @mem
 * @time
 * @caution
 * [고려사항] 삼항 연산자 연습 문제!
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '짝수와 홀수'
public class Programmers12937 {
    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
    public static void main(String[] args) {
        int num = 10;
        System.out.println(solution(num));
    }
}