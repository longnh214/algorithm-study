/**
 * @author nakhoon
 * @date 12/21/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/1845
 * @mem
 * @time
 * @caution
 * [고려사항]
 * int [] 배열을 HashSet으로 stream을 이용해서 변환하고 싶었다.(단순 반복문이 더 효율적이다.)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.util.stream.Collectors;

//프로그래머스 <연습문제> '폰켓몬'
public class Programmers1845 {

    public static void main(String[] args) {
        int [] nums = {3,1,2,3};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        return Math.min(nums.length / 2, set.size());
    }
}
