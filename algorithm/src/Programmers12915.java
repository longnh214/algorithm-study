/**
 * @author nakhoon
 * @date 12/11/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12915
 * @mem
 * @time
 * @caution
 * [고려사항]
 * n번째 문자가 같을 때에는 사전순, 아닐 때에는 Character.compare를 이용해서 정렬해주었다.
 * Comparator.comparingInt(o -> o.charAt(n)) 으로 정렬하고 싶었으나, 분기처리를 위해 사용하지 않았다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '문자열 내 마음대로 정렬하기'
public class Programmers12915 {
    public static void main(String[] args) {
        String [] strings = {"sun", "bed", "car"};

        System.out.println(Arrays.toString(solution(strings, 1)));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n)
            ? o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n)));
        return strings;
    }
}
