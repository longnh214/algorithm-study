/**
 * @author nakhoon
 * @date 11/29/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12917
 * @mem
 * @time
 * @caution
 * [고려사항]
 * stream을 이용해서도 풀어봤고, StringBuilder를 이용한 정답도 찾아보았다.
 * StringBuilder의 reverse 함수가 유용했다. 문자를 거꾸로 할 때 써봐야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//프로그래머스 <연습문제> '문자열 내림차순으로 배치하기'
public class Programmers12917 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
        System.out.println(solution1(s));
    }

    public static String solution(String s) {
       return Stream.of(s.split(""))
           .sorted(Comparator.reverseOrder())
           .collect(Collectors.joining());
    }

    public static String solution1(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new StringBuilder(new String(arr)).reverse().toString();
    }
}