/**
 * @author nakhoonchoi
 * @date 2023/11/25
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12903
 * @mem
 * @time
 * @caution
 * [고려사항]
 * substring과 elvis? 삼항 연산자를 이용해서 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '가운제 글자 가져오기'
public class Programmers12903 {
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = s.substring(s.length() % 2 == 0 ? s.length() / 2 - 1 : s.length() / 2, s.length() / 2 + 1);
        return answer;
    }
}
