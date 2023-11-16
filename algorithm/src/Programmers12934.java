/**
 * @author nakhoon
 * @date 11/17/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12934
 * @mem
 * @time
 * @caution
 * [고려사항]
 * Math.sqrt의 반환 값을 double이 아닌 Double로 받아서 intValue 메소드를 이용하면 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '정수 제곱근 판별'
public class Programmers12934 {
    public static long solution(long n) {
        Double x = Math.sqrt(n);
        if(x == x.intValue()){
            long next = x.intValue() + 1;
            return next * next;
        }
        return -1;
    }
    public static void main(String[] args) {
        long n = 121;
        System.out.println(solution(n));
    }
}