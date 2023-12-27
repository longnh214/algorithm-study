/**
 * @author nakhoon
 * @date 12/28/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12939
 * @mem
 * @time
 * @caution
 * [고려사항]
 * stream 연습용 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '최댓값과 최솟값'
public class Programmers12939 {
    public static void main(String[] args) {
        String s = "1 2 3 4";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        int [] num = Arrays.stream(s.split(" "))
            .mapToInt(i -> Integer.parseInt(i))
            .toArray();

        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        sb.append(num[0]).append(" ").append(num[num.length - 1]);

        return sb.toString();
    }
}
