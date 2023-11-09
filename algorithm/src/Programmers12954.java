/**
 * @author nakhoon
 * @date 11/9/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12954
 * @mem
 * @time
 * @caution
 * [고려사항] stream을 이용한 List to Array 연습용.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> 'x만큼 간격이 있는 n개의 숫자'
public class Programmers12954 {
    public static long[] solution(int x, int n) {
        List<Long> answerList = new ArrayList<>();
        for(int i=0;i<n;i++){
            answerList.add((x + ((long) i * x)));
        }

        return answerList.stream().mapToLong(i -> i).toArray();
    }
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(solution(x,n)));
    }
}
