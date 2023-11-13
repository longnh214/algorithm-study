/**
 * @author nakhoon
 * @date 11/14/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12931
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 숫자를 String으로 변환 후 인덱스를 순회해서 각 자리 수를 더해주었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '자릿수 더하기'
public class Programmers12931 {
    public static int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);

        for(int i=0;i<str.length();i++){
            answer += (str.charAt(i) - '0');
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 123;
        System.out.println(solution(N));
    }
}