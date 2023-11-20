/**
 * @author nakhoon
 * @date 11/21/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12910
 * @mem
 * @time
 * @caution
 * [고려사항]
 * int 배열의 스트림을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '나누어 떨어지는 숫자 배열'
public class Programmers12910 {
    public static void main(String[] args) {
        int [] arr = {5,9,7,10};
        int divisor = 5;
        System.out.println(solution(arr, divisor));
    }

    public static int[] solution(int[] arr, int divisor) {
        List<Integer> answerList = new ArrayList<>();
        Arrays.stream(arr).forEach(i -> {
           if(i % divisor == 0) {
               answerList.add(i);
           }
        });
        if(answerList.isEmpty()){
            answerList.add(-1);
        }
        Collections.sort(answerList);
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}