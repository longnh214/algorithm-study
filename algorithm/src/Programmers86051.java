/**
 * @author nakhoon
 * @date 11/22/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/86051
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 자바 8 중 스트림을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//프로그래머스 <연습문제> '없는 숫자 더하기'
public class Programmers86051 {


    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        return Stream.of(1,2,3,4,5,6,7,8,9,0).filter(number -> !Arrays.stream(numbers).boxed().collect(Collectors.toList()).contains(number))
            .mapToInt(i -> i).sum();
    }
}
