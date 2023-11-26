/**
 * @author nakhoon
 * @date 11/26/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/70128
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.stream.IntStream;

//프로그래머스 <연습문제> '내적'
public class Programmers70128 {
    public static void main(String[] args) {
        int [] a = {1,2,3,4};
        int [] b = {-3, -1, 0, 2};

        System.out.println(solution(a, b));
    }

    public static int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
}
