/**
 * @author nakhoon
 * @date 12/30/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12941
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 두 배열의 곱이 최소값이 되려면 한 배열은 오름차순, 한 배열은 내림차순으로 정렬되어있을 때의 곱이 최소값을
 * 나타낸다는 규칙을 알고 있으면 쉽게 풀 수 있는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '최솟값 만들기'
public class Programmers12941 {
    public static void main(String[] args) {
        int [] A = {1,4,2};
        int [] B = {5,4,4};

        System.out.println(solution(A, B));
    }

    public static int solution(int [] A, int [] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;

        for(int i=0;i<A.length;i++){
            answer += (A[i] * B[B.length - i - 1]);
        }

        return answer;
    }
}