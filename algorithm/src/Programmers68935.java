/**
 * @author nakhoon
 * @date 12/5/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/68935
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 다른 문제를 통해 배웠던 StringBuilder의 reverse를 이용해서 문자열을 뒤집었고,
 * Integer.toString(n, radix), Integer.parseInt(n, radix) 두 함수를 이용해 n진수를 파싱하고 변환했다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '3진법 뒤집기'
public class Programmers68935 {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        return Integer.parseInt(sb.reverse().toString(), 3);
    }
}
