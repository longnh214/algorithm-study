/**
 * @author nakhoon
 * @date 12/6/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12982
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 배열을 정렬 후 순회하면서 budget을 하나씩 빼주면서 최대 부서 개수를 세었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '예산'
public class Programmers12982 {
    public static void main(String[] args) {
        int [] d = {2,2,3,3};
        int budget = 10;
        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i=0;i<d.length;i++){
            if(budget - d[i] < 0) {
                break;
            }
            answer++;
            budget -= d[i];
        }
        return answer;
    }
}
